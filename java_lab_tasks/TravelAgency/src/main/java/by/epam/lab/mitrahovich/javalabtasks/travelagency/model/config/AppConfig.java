package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "by.epam.lab.mitrahovich.javalabtasks.travelagency.model")
// @ComponentScan(basePackages =
// "by.epam.lab.mitrahovich.javalabtasks.travelagency.mainapp")
public class AppConfig {

	public AppConfig() {

	}

	@Bean
	public DataSource getDataSource() {
		HikariConfig config = new HikariConfig("src/main/resources/hikaricp.properties");
		return new HikariDataSource(config);

	}

	@Bean
	@Autowired
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	@Autowired
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource dataSource) {

		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	@Autowired
	public Flyway getFlyway(DataSource dataSource) {

		// Flyway flyway = Flyway.configure().dataSource(dataSource).load();
		// Flyway flyway =
		// Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/travel",
		// "postgres", "root").baselineOnMigrate(true).load();
//
		Flyway flyway = new Flyway();
		flyway.setDataSource(dataSource);
		flyway.setBaselineOnMigrate(true);
		return flyway;

	}

}
