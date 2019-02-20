package services;
/**
 * @author Antoan Hristov and Patrick Wakil
 * @date 2018-02-19
 * JDBC object to interact with database based on needs
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datamodel.Question;
import factory.QuestionFactory;

public class QuestionJDBCDAO {
	
	private Connection getConnection() throws SQLException {
		Configuration conf = Configuration.getInstance();
		String jdbcUrl = conf.getConfigurationValue("jdbc.url");
		String user = conf.getConfigurationValue("jdbc.user");
		String password = conf.getConfigurationValue("jdbc.password");
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}
	
	/**
	 * Return questions on demanded difficulty and topic
	 * @param difficulty wanted
 	 * @param topic wanted
	 * @return list of questions
	 */
	public List<Question> search(int difficulty, String topic) {
		List<Question> resultList = new ArrayList<Question>();
		String selectQuery = "select * from QUESTIONS WHERE difficulty=? and topic=?";
		
		try (Connection connection = getConnection();
				PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
				) {

			selectStatement.setInt(1, difficulty);
			selectStatement.setString(2, topic);
			ResultSet results = selectStatement.executeQuery();
			while (results.next()) {
				resultList.add(QuestionFactory.FACTORY.buildQuestion(results));
			}
			results.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
