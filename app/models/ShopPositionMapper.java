package models;

public interface ShopPositionMapper {
    Integer insert(ShopPosition shopPosition);

    ShopPosition select(Long id);

    Integer update(ShopPosition shopPosition);

    Integer delete(Long id);
}
