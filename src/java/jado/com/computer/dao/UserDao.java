package jado.com.computer.dao;

import jado.com.computer.model.User;
import jado.com.computer.model.Authentications;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String INSERT_USER_SQL = "INSERT INTO usercomputer " + " (regnumber,username,email,phone, serialnumber,identification,school,department,gate,gateman,date) VALUES " + " (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String REGISTER_USER = "INSERT INTO authentication " + " (name,email,phone,passwords) VALUES " + " (?,?,?,?);";
    private static final String LOGIN_USER = "SELECT * FROM authentication where phone=? AND passwords=? ;";
    private static final String SELECT_ALL_USERBYREGN = "SELECT idusercomputer,regnumber,username,email,phone,serialnumber,identification,school,department,gate,gateman,date from usercomputer where regnumber=?;";
    private static final String SELECT_ALL_USER = "SELECT * FROM usercomputer LIMIT ?, ?";
    private static final String COUNT_TOTAL_RECORDSPC = "SELECT COUNT(*) FROM usercomputer;";
    private static final String COUNT_TOTAL_RECORDSPCFORICT = "SELECT COUNT(*) FROM usercomputer WHERE school='ict';";
    private static final String COUNT_TOTAL_RECORDSPCFORMI = "SELECT COUNT(*) FROM usercomputer WHERE school='mining';";
    private static final String COUNT_TOTAL_RECORDSPCFORSC = "SELECT COUNT(*) FROM usercomputer WHERE school='science';";
    private static final String COUNT_TOTAL_RECORDSPCFORARCH = "SELECT COUNT(*) FROM usercomputer WHERE school='architecture';";
    private static final String COUNT_TOTAL_RECORDSPCFORENG = "SELECT COUNT(*) FROM usercomputer WHERE school='engineering';";
    private static final String UPDATE_PSS_BYID = "update authentication set passwords=? where passwords= ?;";

    private static final String DELETE_USER_ID = "delete from usercomputer where regnumber = ?;";
    private static final String UPDATE_PC_BYID = "update user set regnumber=?,username=?,email=?,phone=?,serialnumber=?,identification=?,school=?,department=?,gate=?,gateman=?,date=? where idusercomputer= ?;";
    private static final String SELECT_ALL_USERBYNAME = "SELECT regnumber,username,email,phone,serialnumber,identification,school,department,gate,gateman,date from user where username=?;";
    private static final String SELECT_ALL_GATEMAN = "SELECT idauthentication, name,email,phone FROM authentication WHERE Role='Gateman' LIMIT ?, ?;";
    private static final String SELECT_ALL_GATEMAN_BYID = "SELECT * FROM authentication WHERE idauthentication=?;";
    private static final String SELECT_ALL_GATEMAN_BYNAME = "SELECT idauthentication,name,email,phone,passwords FROM authentication WHERE name = ?;";

    private static final String COUNT_TOTAL_RECORDS = "SELECT COUNT(*) FROM authentication;";
    private static final String DELETE_GATEMAN_ID = "delete from authentication where idauthentication = ?;";
    private static final String UPDATE_GATEMAN_BYID = "update authentication set name=?, email=?,phone =?  where idauthentication= ?;";

    protected Connection getConnection() {

        Connection con = null;
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/computermanagementsystem";
            String username = "root";
            String password = "Mudenge2002@";

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database!");

        } catch (Exception e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();

        }
        return con;
    }

    public void insert(User user) {

        try (Connection Conn = getConnection(); PreparedStatement psa = Conn.prepareStatement(INSERT_USER_SQL);) {

            psa.setInt(1, user.getRegnumber());
            psa.setString(2, user.getUsername());
            psa.setString(3, user.getEmail());
            psa.setString(4, user.getPhone());
            psa.setString(5, user.getSerialnumber());
            psa.setString(6, user.getIdentification());
            psa.setString(7, user.getSchool());
            psa.setString(8, user.getDepartment());
            psa.setString(9, user.getGate());
            psa.setString(10, user.getGateman());
            psa.setString(11, user.getDate());
            psa.executeUpdate();
            System.out.println(" row(s) inserted.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }

    }

    public int updatecre(String name, String email, String phone, int id) {
        int rowupadate = 0;
        Connection Conn = getConnection();
        PreparedStatement psa = null;
        try {
            psa = Conn.prepareStatement(UPDATE_GATEMAN_BYID);
            psa.setString(1, name);
            psa.setString(2, email);
            psa.setString(3, phone);
            psa.setInt(4, id);
            psa.executeUpdate();
            rowupadate = psa.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rowupadate;

    }

    public int updatePSA(String newps, String oldpass) {
        int rowupadate = 0;
        Connection Conn = getConnection();
        PreparedStatement psa = null;
        try {
            psa = Conn.prepareStatement(UPDATE_PSS_BYID);
            psa.setString(1, newps);
            psa.setString(2, oldpass);
            psa.executeUpdate();
            rowupadate = psa.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rowupadate;

    }

    public int updatePC(User user) {
        int rowupadate = 0;
        Connection Conn = getConnection();
        PreparedStatement psa = null;
        try {
            psa = Conn.prepareStatement(UPDATE_PC_BYID);

            psa.setInt(1, user.getRegnumber());
            psa.setString(2, user.getUsername());
            psa.setString(3, user.getEmail());
            psa.setString(4, user.getPhone());
            psa.setString(5, user.getSerialnumber());
            psa.setString(6, user.getIdentification());
            psa.setString(7, user.getSchool());
            psa.setString(8, user.getDepartment());
            psa.setString(9, user.getGate());
            psa.setString(10, user.getGateman());
            psa.setString(11, user.getDate());
            psa.setInt(1, user.getId());

            psa.executeUpdate();
            rowupadate = psa.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rowupadate;

    }

    public int deleteGateman(int id) {
        Connection Conn = getConnection();
        PreparedStatement psa = null;
        int rowupadate = 0;
        try {
            psa = Conn.prepareStatement(DELETE_GATEMAN_ID);
            psa.setInt(1, id);
            rowupadate = psa.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowupadate;
    }

    public int deletePC(int regnumber) {
        Connection Conn = getConnection();
        PreparedStatement psa = null;
        int rowupadate = 0;
        try {
            psa = Conn.prepareStatement(DELETE_USER_ID);
            psa.setInt(1, regnumber);
            rowupadate = psa.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowupadate;
    }

    public void registergateman(Authentications authentications) {

        try (Connection Conn = getConnection(); PreparedStatement psa = Conn.prepareStatement(REGISTER_USER);) {

            psa.setString(1, authentications.getName());
            psa.setString(2, authentications.getEmail());
            psa.setString(3, authentications.getPhone());
            psa.setString(4, authentications.getPasswords());

            psa.executeUpdate();
            System.out.println(" row(s) inserted.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }

    }

    public Authentications seclectGateMan(int ids) {
        Authentications gatemanselected = null;

        try (Connection Conn = getConnection(); PreparedStatement psa = Conn.prepareStatement(SELECT_ALL_GATEMAN_BYID);) {

            psa.setInt(1, ids);
          
            System.out.println(psa);
            ResultSet rs = psa.executeQuery();
            while (rs.next()) {
                int idd = rs.getInt("idauthentication");
                String names = rs.getString("name");
                String emails = rs.getString("email");
                String phones = rs.getString("phone");
                String passowrds = rs.getString("passowrds");
                gatemanselected = new Authentications(idd, names, emails, phones, passowrds);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return gatemanselected;

    }

    public Authentications loginData(String phone, String passwords) {
        Authentications loginuser = null;

        try (Connection Conn = getConnection(); PreparedStatement psa = Conn.prepareStatement(LOGIN_USER);) {

            psa.setString(1, phone);
            psa.setString(2, passwords);
            System.out.println(psa);
            ResultSet rs = psa.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idauthentication");
                String name = rs.getString("name");
                String emails = rs.getString("email");
                String phones = rs.getString("phone");
                String roles = rs.getString("Role");
                String pass = rs.getString("passwords");

                loginuser = new Authentications(id, name, emails, phones, pass, roles);

//                signup = new SignUp( name, email, phone);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return loginuser;

    }

    public int getTotalRecords() {
        int totalRecords = 0;

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(COUNT_TOTAL_RECORDS); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalRecords = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRecords;
    }

    public int getTotalRecordsPC() {
        int totalRecordspc = 0;

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(COUNT_TOTAL_RECORDSPC); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalRecordspc = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRecordspc;
    }

    public int getTotalRecordsPCICT() {
        int totalRecordspcict = 0;

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(COUNT_TOTAL_RECORDSPCFORICT); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalRecordspcict = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRecordspcict;
    }

    public int getTotalRecordsPCMIN() {
        int totalRecordspcict = 0;

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(COUNT_TOTAL_RECORDSPCFORMI); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalRecordspcict = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRecordspcict;
    }

    public int getTotalRecordsPCARCH() {
        int totalRecordspcict = 0;

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(COUNT_TOTAL_RECORDSPCFORARCH); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalRecordspcict = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRecordspcict;
    }

    public int getTotalRecordsPCSC() {
        int totalRecordspcsc = 0;

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(COUNT_TOTAL_RECORDSPCFORSC); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalRecordspcsc = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRecordspcsc;
    }

    public int getTotalRecordsENG() {
        int totalRecordspceng = 0;

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(COUNT_TOTAL_RECORDSPCFORENG); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalRecordspceng = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRecordspceng;
    }

    public List<User> seclectUserByRegnumber(String regnumber) {
        List<User> user = new ArrayList<>();

        try (Connection Conn = getConnection(); PreparedStatement psa = Conn.prepareStatement(SELECT_ALL_USERBYREGN);) {

            psa.setString(1, regnumber);
            System.out.println(psa);
            ResultSet rs = psa.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idusercomputer");
                int regnumbern = rs.getInt("regnumber");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String serialnumber = rs.getString("serialnumber");
                String identification = rs.getString("identification");
                String school = rs.getString("school");
                String department = rs.getString("department");
                String gate = rs.getString("gate");
                String gateman = rs.getString("gateman");
                String date = rs.getString("date");

                user.add(new User(id, regnumbern, username, email, phone, serialnumber, identification, school, department, gate, gateman, date));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return user;

    }

    public List<Authentications> seclectGatemanByname(String name) {
        List<Authentications> gateman = new ArrayList<>();

        try (Connection Conn = getConnection(); PreparedStatement psa = Conn.prepareStatement(SELECT_ALL_GATEMAN_BYNAME);) {

            psa.setString(1, name);
            System.out.println(psa);
            ResultSet rs = psa.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("idauthentication");
                String names = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                gateman.add(new Authentications(id, names, email, phone));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return gateman;

    }

    public List<User> seclectAllUser(int offsetpc, int recordsPerPagepc) {
        List<User> user = new ArrayList<>();

        try (Connection Conn = getConnection(); PreparedStatement psa = Conn.prepareStatement(SELECT_ALL_USER);) {
            psa.setInt(1, offsetpc);
            psa.setInt(2, recordsPerPagepc);
            System.out.println(psa);
            ResultSet rs = psa.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idusercomputer");
                int regnumber = rs.getInt("regnumber");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String serialnumber = rs.getString("serialnumber");
                String identification = rs.getString("identification");
                String school = rs.getString("school");
                String department = rs.getString("department");
                String gate = rs.getString("gate");
                String gateman = rs.getString("gateman");
                String date = rs.getString("date");

                user.add(new User(id, regnumber, username, email, phone, serialnumber, identification, school, department, gate, gateman, date));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }

    public List<Authentications> seclectAllgateman(int offset, int recordsPerPage) {
        List<Authentications> gateman = new ArrayList<>();

        try (Connection Conn = getConnection(); PreparedStatement psa = Conn.prepareStatement(SELECT_ALL_GATEMAN);) {

            psa.setInt(1, offset);
            psa.setInt(2, recordsPerPage);
            System.out.println(psa);
            ResultSet rs = psa.executeQuery();
            while (rs.next()) {

                int ids = rs.getInt("idauthentication");
                String names = rs.getString("name");
                String emails = rs.getString("email");
                String phones = rs.getString("phone");

                gateman.add(new Authentications(ids, names, emails, phones));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return gateman;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
