package com.belhard.webappbank.beans;

public class ResponseCodeBean {

	private int code;
	private String msg;
	private Object bean;
	
	
	
	public ResponseCodeBean() {
		super();
	}
	
	
	
	public ResponseCodeBean(int code, Object bean) {
		super();
		this.code = code;
		this.bean = bean;
	}



	public ResponseCodeBean(int code, String msg, Object bean) {
		super();
		this.code = code;
		this.msg = msg;
		this.bean = bean;
	}
	
	
	public ResponseCodeBean(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ResponseCodeBean(int code) {
		super();
		this.code = code;
	}


	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getBean() {
		return bean;
	}
	public void setBean(Object bean) {
		this.bean = bean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bean == null) ? 0 : bean.hashCode());
		result = prime * result + code;
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseCodeBean other = (ResponseCodeBean) obj;
		if (bean == null) {
			if (other.bean != null)
				return false;
		} else if (!bean.equals(other.bean))
			return false;
		if (code != other.code)
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErrorBean [code=" + code + ", msg=" + msg + ", bean=" + bean + "]";
	}
	
	
}
