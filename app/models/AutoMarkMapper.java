package models;

import org.apache.ibatis.annotations.*;

public interface AutoMarkMapper {
    @Insert("insert into auto_mark (name, country) " +
            " values(#{name}, #{country})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer insert(AutoMark autoMark);

    @Select("select * from auto_mark where id = #{id}")
    AutoMark select(Long id);

    @Update("update auto_mark set name = #{name}, country = #{country}")
    Integer update(AutoMark autoMark);

    @Delete("delete from auto_mark where id = #{id}")
    Integer delete(Long id);
}
