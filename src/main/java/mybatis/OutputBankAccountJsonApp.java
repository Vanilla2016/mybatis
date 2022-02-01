package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import clinic.finance.beans.BankAccount;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.ClassPath;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import mybatis.datasource.DataSourceFactoryImpl;
import mybatis.mappers.DataMapper;
import oracle.jdbc.proxy.annotation.GetCreator;

/**
 * OutputBankAccountJsonApp. Retrieves key details regarding Bank Account information from MySQL database table.
 * Outputs them in JSON format.
 *
 */
public class OutputBankAccountJsonApp 
{
    public static void main( String[] args ) throws IOException
    {
    	
    	Properties prop = new Properties();
    	prop.setProperty("driver", "com.mysql.jdbc.Driver");
    	prop.setProperty("url", "jdbc:mysql://localhost:3306/?user=root");
    	prop.setProperty("user", "root");
    	prop.setProperty("password", "Sm0k3sqlstack3r");
    	
    	DataSourceFactoryImpl dataSourceFactoryImpl = new DataSourceFactoryImpl();
    	dataSourceFactoryImpl.setProperties(prop);
    	
    	DataSource dataSource = dataSourceFactoryImpl.getDataSource();
    	
    	TransactionFactory transactionFactory = new JdbcTransactionFactory();
    	Environment environment = 
    			new Environment("development", transactionFactory, dataSource);
    	Configuration configuration = new Configuration(environment);
    	configuration.addMapper(DataMapper.class);
    	
    	SqlSessionFactory sqlSessionFactory = 
    			new SqlSessionFactoryBuilder().build(configuration);
    	
    	try(SqlSession session = sqlSessionFactory.openSession()){
    		List<BankAccount> bankAccounts = session.selectList("getAllAccountsDetails", new Object());
    		
    		System.out.println("Account Details are as follows : ");
    		for (BankAccount bankAccount : bankAccounts) {
    			System.out.println(bankAccount.toJSON());
    		}
    	}
    	
    }
}
