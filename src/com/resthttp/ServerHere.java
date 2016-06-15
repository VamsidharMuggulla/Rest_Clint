package com.resthttp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("peoples/contacts/")
public class ServerHere {
	JSONArray jsona;
	JSONObject json;

	@Path("get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getData() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String statement = "";

		jsona = new JSONArray();
		json = new JSONObject();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver Loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost/angular", "angular", "angular");

			System.out.println("Connected To MySql");

			statement = "SELECT * FROM contacts;";

			System.out.println("STATEMENT : " + statement);
			ps = con.prepareStatement(statement);

			ResultSet rs = ps.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = count + 1;
			}
			rs.beforeFirst();

			if (count == 0) {
				ps.close();
				con.close();
				System.out.println("Empty Table Ya");
				String x = "";
				return Response.ok(x).build();
			}

			else {
				while (rs.next()) {
					json = new JSONObject();
					json.put("name", rs.getString("name"));
					json.put("number", rs.getString("number"));
					jsona.put(json);

				}

				ps.close();
				con.close();
				System.out.println(jsona + "JSON ARRAY");

				String x = jsona.toString();
				return Response.ok(x).build();
			}
		} catch (Exception e) {
			ps.close();
			con.close();
			System.out.println("HEY SQL EXCEPTION : " + e.getMessage());

			// e.printStackTrace();
		}

		return null;
	}

	@Path("put")
	@PUT
	public Response putData(@QueryParam("name") String name, @QueryParam("number") String number) throws SQLException {

		String x = "PUT Service NOT OK";

		Connection con = null;
		PreparedStatement ps = null;
		String statement = "";

		jsona = new JSONArray();
		json = new JSONObject();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver Loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost/angular", "angular", "angular");

			System.out.println("Connected To MySql");

			statement = "UPDATE contacts SET number='" + number + "' where name='" + name + "';";
			// UPDATE contacts SET number='number' where name='9846546547';

			System.out.println("STATEMENT : " + statement);
			ps = con.prepareStatement(statement);

			int rs = ps.executeUpdate();
			if (rs == 1) {
				x = "UPDATED!";
				return Response.ok(x).build();
			} else {
				x = "INVALID NAME OR NUMBER!!!";
				return Response.ok(x).build();
			}

		} catch (Exception e) {
			ps.close();
			con.close();
			System.out.println("HEY SQL EXCEPTION : " + e.getMessage());
			x = "INVALID NAME OR NUMBER!!!";
			return Response.ok(x).build();
			// e.printStackTrace();
		}

	}

	@Path("post")
	@POST
	public Response postData(@QueryParam("name") String name, @QueryParam("number") String number) throws SQLException {

		String x = "POT Service NOT OK";

		Connection con = null;
		PreparedStatement ps = null;
		String statement = "";

		jsona = new JSONArray();
		json = new JSONObject();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver Loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost/angular", "angular", "angular");

			System.out.println("Connected To MySql");

			statement = "INSERT INTO contacts values('" + name + "','" + number + "');";
			// UPDATE contacts SET number='number' where name='9846546547';

			System.out.println("STATEMENT : " + statement);
			ps = con.prepareStatement(statement);

			int rs = ps.executeUpdate();
			if (rs == 1) {
				x = "POSTED!";
				return Response.ok(x).build();
			} else {
				x = "INVALID NAME OR NUMBER!!!";
				return Response.ok(x).build();
			}

		} catch (Exception e) {
			ps.close();
			con.close();
			System.out.println("HEY SQL EXCEPTION : " + e.getMessage());
			x = "INVALID NAME OR NUMBER!!!";
			return Response.ok(x).build();
			// e.printStackTrace();
		}

	}

	@Path("delete")
	@DELETE
	public Response deleteData(@QueryParam("name") String name, @QueryParam("number") String number) throws SQLException {

		String x = "DELETE Service NOT OK";

		Connection con = null;
		PreparedStatement ps = null;
		String statement = "";

		jsona = new JSONArray();
		json = new JSONObject();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver Loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost/angular", "angular", "angular");

			System.out.println("Connected To MySql");

			statement = "DELETE FROM contacts where name='" + name + "' AND number='" + number + "';";
			//  delete from contacts where name='Sai';


			System.out.println("STATEMENT : " + statement);
			ps = con.prepareStatement(statement);

			int rs = ps.executeUpdate();
			if (rs == 1) {
				x = "DELETED!";
				return Response.ok(x).build();
			} else {
				x = "INVALID NAME OR NUMBER!!!";
				return Response.ok(x).build();
			}

		} catch (Exception e) {
			ps.close();
			con.close();
			System.out.println("HEY SQL EXCEPTION : " + e.getMessage());
			x = "INVALID NAME OR NUMBER!!!";
			return Response.ok(x).build();
			// e.printStackTrace();
		}

	}

}
