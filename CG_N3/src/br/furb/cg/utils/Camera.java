package br.furb.cg.utils;

public class Camera {
	private int xMinOrtho2D;
	private int xMaxOrtho2D;
	private int yMinOrtho2D;
	private int yMaxOrtho2D;

	public Camera(int xMinOrtho2D, int xMaxOrtho2D, int yMinOrtho2D, int yMaxOrtho2D) {
		this.xMinOrtho2D = xMinOrtho2D;
		this.xMaxOrtho2D = xMaxOrtho2D;
		this.yMinOrtho2D = yMinOrtho2D;
		this.yMaxOrtho2D = yMaxOrtho2D;
	}

	public void pan() {

	}

	public void zoom(int x) {
		this.xMinOrtho2D -= x;
		this.xMaxOrtho2D += x;
		this.yMinOrtho2D += x;
		this.yMaxOrtho2D -= x;
	}

	public int getxMinOrtho2D() {
		return xMinOrtho2D;
	}

	public void setxMinOrtho2D(int xMinOrtho2D) {
		this.xMinOrtho2D = xMinOrtho2D;
	}

	public int getxMaxOrtho2D() {
		return xMaxOrtho2D;
	}

	public void setxMaxOrtho2D(int xMaxOrtho2D) {
		this.xMaxOrtho2D = xMaxOrtho2D;
	}

	public int getyMinOrtho2D() {
		return yMinOrtho2D;
	}

	public void setyMinOrtho2D(int yMinOrtho2D) {
		this.yMinOrtho2D = yMinOrtho2D;
	}

	public int getyMaxOrtho2D() {
		return yMaxOrtho2D;
	}

	public void setyMaxOrtho2D(int yMaxOrtho2D) {
		this.yMaxOrtho2D = yMaxOrtho2D;
	}
}
