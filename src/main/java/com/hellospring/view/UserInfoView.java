package com.hellospring.view;

public class UserInfoView {
	public interface UserIdView extends ResultView.ResultInfoView{}
	//public interface OnlyUserInfoView extends ResultView.ResultInfoView {}
	public interface OnlyUserInfoView extends UserIdView {}
	public interface AllUserInfoView extends OnlyUserInfoView, CarInfoView.CarAllView, TrackInfoView.TrackView {}
	
}
