package example.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import example.com.bean.Director;

public class DirectorDAO {
	private Connection con;

	/**
	 * コンストラクタ
	 * @param con コネクション
	 */
	public DirectorDAO(Connection con) {
		this.con = con;
	}
	/**
	 * 監督情報全件検索
	 * @return List<Director> 監督情報一覧
	 */
	public List<Director> selectAll() throws SQLException {

		String sql = "SELECT ID, NAME,BIRTH FROM DIRECTOR ORDER BY ID";

		List<Director> list = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Director director = new Director();
				director.setId(rs.getInt("ID"));
				director.setName(rs.getString("NAME"));
				director.setBirth(rs.getDate("BIRTH"));
				list.add(director);
			}
		}
		return list;
	}
	/**
	 * 引数で受け取ったidで監督検索
	 * @param id 監督ID
	 * @return director 監督情報
	 */
	public Director selectById(int id) throws SQLException {

		String sql = "SELECT ID, NAME, BIRTH FROM DIRECTOR WHERE ID = ?";

		Director director = null;

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					director = new Director();
					director.setId(rs.getInt("ID"));
					director.setName(rs.getString("NAME"));
					director.setBirth(rs.getDate("BIRTH"));
				}
			}
		}
		return director;
	}
	/**
	 * 引数で受け取った監督情報をテーブルへ登録
	 * @param director 監督情報
	 * @return int 登録件数
	 */
	public int insert(Director director) throws SQLException {

		String sql = "INSERT INTO DIRECTOR(ID,NAME,BIRTH) VALUES (?, ?, ?)";

		int cnt = 0;

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, director.getId());
			ps.setString(2, director.getName());
			ps.setDate(3, director.getBirth());

			cnt = ps.executeUpdate();
		}
		return cnt;
	}
	/**
	 * 引数で受け取った監督情報でテーブルを更新
	 * @param director 監督情報
	 * @return int 登録件数
	 */
	public int update(Director director) throws SQLException {

		String sql = "UPDATE DIRECTOR SET NAME = ?, BIRTH = ? WHERE ID = ?";

		int cnt = 0;

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			System.out.println(director);
			ps.setString(1, director.getName());
			ps.setDate(2, director.getBirth());
			ps.setInt(3, director.getId());

			cnt = ps.executeUpdate();
		}
		return cnt;
	}
}
