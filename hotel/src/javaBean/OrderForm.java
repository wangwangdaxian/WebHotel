package javaBean;

public class OrderForm extends AdvanceOrder {
	private String admsId;
	private String admsName;
	private String roomId;
	private String OrderState;
	public String getAdmsId() {
		return admsId;
	}
	public void setAdmsId(String admsId) {
		this.admsId = admsId;
	}
	public String getAdmsName() {
		return admsName;
	}
	public void setAdmsName(String admsName) {
		this.admsName = admsName;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getOrderState() {
		return OrderState;
	}
	public void setOrderState(String orderState) {
		OrderState = orderState;
	}
	
}
