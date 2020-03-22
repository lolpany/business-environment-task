package models;

public interface  AutoModelMapper {
    Integer insert(AutoModel autoModel);

    AutoModel select(Long id);

    Integer update(AutoModel autoModel);

    Integer delete(Long id);
}
