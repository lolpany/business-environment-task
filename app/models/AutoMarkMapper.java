package models;

public interface AutoMarkMapper {
    Integer insert(AutoMark autoMark);

    AutoMark select(Long id);

    Integer update(AutoMark autoMark);

    Integer delete(Long id);
}
