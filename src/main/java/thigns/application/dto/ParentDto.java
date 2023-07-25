package thigns.application.dto;

public record ParentDto(DatabaseDto database_id) {
    public record DatabaseDto(String databaseId) {
    
    }
}
