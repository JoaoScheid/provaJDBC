import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDBrincadeira {

    BancoDeDados bancoDeDados = new BancoDeDados();



    public Brincadeira adicionarBrincadeira(Brincadeira brincadeira){
        try(Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO brincadeira(nome, sede, fome, energia, diversao, higiene) VALUES (?,?,?,?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, brincadeira.getNome());
            ps.setInt(2, brincadeira.getSede());
            ps.setInt(3, brincadeira.getFome());
            ps.setInt(4, brincadeira.getEnergia());
            ps.setInt(5, brincadeira.getDivertimento());
            ps.setInt(6, brincadeira.getSujeira());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                brincadeira.setCodigo(rs.getInt(1));
                return brincadeira;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException("Não foi possivel adicionar uma brincadeira");
    }

    public List<Brincadeira> buscarBrincadeira(){
        try (Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM brincadeira");
            ResultSet rs = ps.executeQuery();
            List<Brincadeira> brincadeiras = new ArrayList<>();
            while (rs.next()) {
                brincadeiras.add(new Brincadeira(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)
                ));
            }
            return brincadeiras;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Brincadeira buscarBrincadeiraByCodigo(int codigo)  {
        try (Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM brincadeira WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                int sede = rs.getInt("sede");
                int fome = rs.getInt("fome");
                int energia = rs.getInt("energia");
                int diversao = rs.getInt("diversao");
                int higiene = rs.getInt("higiene");
                return new Brincadeira(codigo, nome, diversao, energia, fome, sede, higiene);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Brincadeira nao encotrado");
    }

    public void updateBrincadeira(Brincadeira brincadeira){
        buscarBrincadeiraByCodigo(brincadeira.getCodigo());
        try (Connection connection = bancoDeDados.getConexao()){
            PreparedStatement ps = connection.prepareStatement("UPDATE brincadeira SET nome = ?, sede = ?, fome = ?, energia = ?, diversao = ?, higiene = ? WHERE codigo = ?");
            ps.setString(1, brincadeira.getNome());
            ps.setInt(2, brincadeira.getSede());
            ps.setInt(3, brincadeira.getFome());
            ps.setInt(4, brincadeira.getEnergia());
            ps.setInt(5, brincadeira.getDivertimento());
            ps.setInt(6, brincadeira.getSujeira());
            ps.setInt(7, brincadeira.getCodigo());
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Erro ao atualizar brincadeira");
    }
    public void removerBrincadeira(int codigo){
        try(Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM brincadeira WHERE codigo = ?");
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
