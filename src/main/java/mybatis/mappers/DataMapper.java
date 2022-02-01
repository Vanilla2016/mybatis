package mybatis.mappers;

import org.apache.ibatis.annotations.Select;

public interface DataMapper {
	@Select("Select COUNT(*) from wds_fin.account")
	public int getNumberOfAccounts();
}
