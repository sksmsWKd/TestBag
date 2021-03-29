
public class GenericBox<T> { // <변수> 제너릭 클래스 소문자 대문자 전부가능
	private T content;       //generic class .type parameter

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
