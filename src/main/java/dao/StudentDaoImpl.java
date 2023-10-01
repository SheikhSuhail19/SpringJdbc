package dao;

import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		String query = "INSERT INTO STUDENT(id, name, city) VALUES(?, ?, ?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	@Override
	public int change(Student student) {
		String query = "UPDATE STUDENT SET name=?, city=? WHERE id=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	@Override
	public int delete(int studentId) {
		String query = "DELETE FROM STUDENT WHERE id=?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}

	@Override
	public Student getStudent(int studentId) {
		String query = "SELECT * FROM STUDENT WHERE id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		String query = "SELECT * FROM STUDENT";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		List<Student> student = this.jdbcTemplate.query(query, rowMapper);
		return student;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
