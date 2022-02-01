package mybatis.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import clinic.finance.beans.BankAccount;


public class BankAccountSerializer extends StdSerializer<BankAccount>{

	public BankAccountSerializer(Class<BankAccount> t) {
		super(t);
	}

	@Override
	public void serialize(BankAccount bankAccount, JsonGenerator jsonGenerator, 
								   SerializerProvider serializerProvider) throws IOException {
		
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("account id", bankAccount.getAccountId());
		jsonGenerator.writeNumberField("account balance", bankAccount.getAccountBalance());
		jsonGenerator.writeStringField("account type", bankAccount.getAccountType());
		jsonGenerator.writeStringField("account name", bankAccount.getAccountName());
		jsonGenerator.writeNumberField("account interest", bankAccount.getAccountInterest());
		
		jsonGenerator.writeEndObject(); //end address object
	
	}

}
