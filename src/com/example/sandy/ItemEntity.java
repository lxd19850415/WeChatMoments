package com.example.sandy;

import java.util.ArrayList;

public class ItemEntity {
	private String avatar;
	private String title;
	private String content;
	private ArrayList<String> imageUrls;
	private ArrayList<Comment> comments;

	public ItemEntity(String avatar, String title, String content,
			ArrayList<String> imageUrls, ArrayList<Comment> comments) {
		super();
		this.avatar = avatar;
		this.title = title;
		this.content = content;
		this.imageUrls = imageUrls;
		this.comments = comments;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "ItemEntity [avatar=" + avatar + ", title=" + title
				+ ", content=" + content + ", imageUrls=" + imageUrls
				+ ", comment=" + comments.toString() + "]";
	}

	public static class Comment {

		private String commenter;
		private String commentContent;

		public Comment(String commenter, String commentContent) {
			super();
			this.commenter = commenter;
			this.commentContent = commentContent;
		}

		public String getCommenter() {
			return commenter;
		}

		public void setCommenter(String commenter) {
			this.commenter = commenter;
		}

		public String getCommentContent() {
			return commentContent;
		}

		public void setCommentContent(String commentContent) {
			this.commentContent = commentContent;
		}

		@Override
		public String toString() {
			return commenter + ":" + commentContent;
		}

	}
}
