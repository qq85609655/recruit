package generator.pojo;

public enum DatabaseType {
  ORACLE("oracle"), MYSQL("mysql"), POSTGRES("postgres"), GENERAL("");
  
  private String pack;
  
  private DatabaseType(String pack) {
    this.setPack(pack);
  }

  public String getPack() {
    return pack;
  }

  private void setPack(String pack) {
    this.pack = pack;
  }
}
