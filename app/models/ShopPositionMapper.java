package models;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface ShopPositionMapper {
    @Insert("insert into shop_position (mark_id, model_id, year_of_production, mileage, price) " +
            " values(#{markId}, #{modelId}, #{yearOfProduction}, #{mileage}, #{price})")
    @SelectKey(statement="call identity()", keyProperty="id", before=false, resultType=Long.class)
    Long insert(ShopPosition shopPosition);

    @Select("select * from shop_position where id = #{id}")
    ShopPosition select(Long id);

    Integer update(ShopPosition shopPosition);

    Integer delete(Long id);
}
