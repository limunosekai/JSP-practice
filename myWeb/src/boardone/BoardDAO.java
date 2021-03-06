package boardone;

import java.sql.*;
import java.util.*;

public class BoardDAO {
	private static BoardDAO instance = null;
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			synchronized(BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		System.out.println("�ν��Ͻ� ����");
		return instance;
	}
	
	// DB�� �� �ֱ�
	public void insertArticle(BoardVO article) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();
		int number = 0; // 
		String sql = "";
		try {
			conn = ConnUtil.getConnection();
			pstm = conn.prepareStatement("select max(ref) from board");
			rs = pstm.executeQuery();
			if(rs.next()) {
				number = rs.getInt(1) + 1;
			} else {
				number = 1;
			}
			// �亯���ϰ��
			if(num != 0) {
				sql = "update board set step=step+1 where ref=? and step > ?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1,ref);
				pstm.setInt(2,step);
				pstm.executeUpdate();
				step+=1;
				depth+=1;
			} else { // �� ���� ���
				ref = number;
				step = 0;
				depth = 0;
				System.out.println("�����Դϴ�.");
			}
			sql = "insert into board(num,writer,email,subject,pass,ref,step,depth,regdate,content,ip) values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, article.getWriter());
			pstm.setString(2, article.getEmail());
			pstm.setString(3, article.getSubject());
			pstm.setString(4, article.getPass());
			pstm.setInt(5, ref);
			pstm.setInt(6, step);
			pstm.setInt(7, depth);
			pstm.setTimestamp(8, article.getRegdate());
			pstm.setString(9, article.getContent());
			pstm.setString(10, article.getIp());
			pstm.executeQuery();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
	
	// ��ü ���� ���� �ҷ�����
	public int getArticleCount() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int x = 0;
		try {
			conn = ConnUtil.getConnection();
			pstm = conn.prepareStatement("select count(*) from board");
			rs = pstm.executeQuery();
			if(rs.next()) {
				x = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return x;
	}
	
	// �Խ��� �� �ҷ�����(��ü)
	public List<BoardVO> getArticles(int start, int end) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;
		try {
			conn = ConnUtil.getConnection();
			pstm = conn.prepareStatement("select * from (select rownum rnum, num, writer, email, subject, pass, regdate, readcount, ref, step, depth, content, ip from (select * from board order by ref desc, step asc)) where rnum>=? and rnum<=?"); // ����3
			pstm.setInt(1, start);
			pstm.setInt(2, end);
			rs = pstm.executeQuery();
			if(rs.next()) {
				articleList = new ArrayList<BoardVO>(end-start+1);
				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					articleList.add(article);
				} while(rs.next());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return articleList;
	}
	
	// �Խ��� �� �������� (�ϳ�)
	public BoardVO getArticle(int num, String mode) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		BoardVO article = null;
		try {
			conn = ConnUtil.getConnection();
			if(mode.equals("content")) {
				pstm = conn.prepareStatement("update board set readcount=readcount+1 where num=?");
				pstm.setInt(1, num);
				pstm.executeUpdate();
			}
			pstm = conn.prepareStatement("select * from board where num=?");
			pstm.setInt(1, num);
			rs = pstm.executeQuery();
			if(rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return article;
	}
	
	// �� ���� 
	public int updateArticle(BoardVO article) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String dbpass = "";
		String sql = "";
		int result = -1;
		try {
			conn = ConnUtil.getConnection();
			pstm = conn.prepareStatement("select pass from board where num=?");
			pstm.setInt(1, article.getNum());
			rs = pstm.executeQuery();
			if(rs.next()) {
				dbpass = rs.getString("pass");
				if(dbpass.equals(article.getPass())) {
					sql = "update board set writer=?,email=?,subject=?,content=? where num=?";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, article.getWriter());
					pstm.setString(2, article.getEmail());
					pstm.setString(3, article.getSubject());
					pstm.setString(4, article.getContent());
					pstm.setInt(5, article.getNum());
					pstm.executeUpdate();
					result = 1; // ���� ����
				} else {
					result = 0; // ���� ����
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	
	// �� ����
	public int deleteArticle(int num, String pass) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String dbpass = "";
		int result = -1;
		try {
			conn = ConnUtil.getConnection();
			pstm = conn.prepareStatement("select pass from board where num=?");
			pstm.setInt(1, num);
			rs = pstm.executeQuery();
			if(rs.next()) {
				dbpass = rs.getString("pass");
				if(dbpass.equals(pass)) {
					pstm = conn.prepareStatement("delete from board where num=?");
					pstm.setInt(1, num);
					pstm.executeUpdate();
					result = 1; // ���� ����
				} else {
					result = 0; // ���� ����
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
}
