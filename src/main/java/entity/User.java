package entity;


public class User {
  private String id;
  private String name;

  public User(String id, String name){
    this.id = id;
    this.name = name;
  }

  //idのゲッター
  public String getId(){
    return this.id;
  }

  //idのセッター
  public void setId(String id){
    this.id = id;
  }

  //nameのゲッター
  public String getName(){
    return this.name;
  }
  
  //nameのセッター
  public void setName(String name){
    this.name = name;
  }
  

}