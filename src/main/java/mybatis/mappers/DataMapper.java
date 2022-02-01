package mybatis.mappers;

import org.apache.ibatis.annotations.Select;

import clinic.finance.beans.BankAccount;

public interface DataMapper {
	@Select("Select COUNT(*) from wds_fin.account")
	public int getNumberOfAccounts();

	@Select("Select idaccount, accountbalance, accounttype, accountname, accountinterest from wds_fin.account")
	public BankAccount getAllAccountsDetails();
}
