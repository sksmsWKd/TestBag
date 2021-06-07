// 21/06/07
//with JSONReader
public class Post {
	private int userId;
	private int id;
	private String title;
	private String body;
	
	//private 라서 외부에서 수정불가
	//세팅 가능하게 public set메서드 만듬.
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
}
