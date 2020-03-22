package models;

import org.apache.ibatis.annotations.*;

public interface  AutoModelMapper {
    @Insert("insert into auto_model (name, production_start_year, production_end_year) " +
            " values(#{name}, #{productionStartYear}, #{productionEndYear})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer insert(AutoModel autoModel);

    @Select("select * from auto_model where id = #{id}")
    AutoModel select(Long id);

    @Update("update auto_model set name = #{name}, production_start_year = #{productionStartYear}," +
            "production_end_year = #{productionEndYear}")
    Integer update(AutoModel autoModel);

    @Delete("delete from auto_model where id = #{id}")
    Integer delete(Long id);
}
