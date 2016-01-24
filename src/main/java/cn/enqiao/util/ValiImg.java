package cn.enqiao.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValiImg
 */
public class ValiImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValiImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setDateHeader("Expires", -1);

		response.setHeader("Cache-Control", "no-cache");

		response.setHeader("Pragma", "no-cache");

		int height = 30;

		int width = 120;

		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = (Graphics2D) img.getGraphics();

		g.setColor(Color.BLUE);

		g.fillRect(0, 0, width, height);

		g.setColor(Color.red);

		g.drawRect(0, 0, width - 1, height - 1);

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < 4; i++) {

			g.setColor(new Color(randNum(100, 255), randNum(100, 255), randNum(
					100, 255)));

			g.setFont(new Font("黑体", Font.BOLD, 30));

			String s = "" + str.charAt(randNum(0, str.length()));

			buffer.append(s);

			g.drawString(s, 0 + 30 * i, 25);

		}

		request.getSession().setAttribute("valistr", buffer.toString());
		ImageIO.write(img, "png", response.getOutputStream());

	}

	private int randNum(int i, int j) {
		Random rand = new Random();
		int tmp = rand.nextInt(j - i ) + i;
		return tmp;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
