package models;

import org.apache.ibatis.annotations.*;

public interface ShopPositionMapper {
    @Insert("insert into shop_position (mark_id, model_id, year_of_production, mileage, price) " +
            " values(#{markId}, #{modelId}, #{yearOfProduction}, #{mileage}, #{price})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    long insert(ShopPosition shopPosition);

    @Select("select * from shop_position where id = #{id}")
    ShopPosition select(Long id);

    @Update("update shop_position set year_of_production = #{yearOfProduction}, mileage = #{mileage}," +
            "price = #{price}")
    Integer update(ShopPosition shopPosition);

    @Delete("delete from shop_position where id = #{id}")
    Integer delete(Long id);
}
