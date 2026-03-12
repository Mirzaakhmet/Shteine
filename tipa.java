enum AccessLevel {
    PUBLIC,
    PROTECTED,
    PRIVATE
}

class FileRecord {

    String name;
    long size;
    AccessLevel level;

    public FileRecord(string name, long size, AccessLevel level) {
        this.name = name;
        this.size = size;
        this.level = level;
    }
}