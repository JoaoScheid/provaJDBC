import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDAlimento {
    BancoDeDados bancoDeDados = new BancoDeDados();



    public Alimento adicionarAlimento(Alimento alimento){
        try(Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO alimento(nome, nutricao) VALUES (?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alimento.getNome());
            ps.setInt(2, alimento.getNutricao());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                alimento.setCodigo(rs.getInt(1));
                return alimento;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException("Não foi possivel adicionar um elemento");
    }

    public List<Alimento> buscarAlimentos(){
        try (Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM alimento");
            ResultSet rs = ps.executeQuery();
            List<Alimento> alimentos = new ArrayList<>();
            while (rs.next()) {
                alimentos.add(new Alimento(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                ));
            }
            return alimentos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Alimento buscarAlimentoByCodigo(int codigo)  {
        try (Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM alimento WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                int nutricao = rs.getInt("nutricao");
                return new Alimento(codigo, nome,nutricao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Alimento nao encotrado");
    }

    public void updateAlimento(Alimento alimento){
        buscarAlimentoByCodigo(alimento.getCodigo());
        try (Connection connection = bancoDeDados.getConexao()){
            PreparedStatement ps = connection.prepareStatement("UPDATE alimento SET nome = ?, nutricao = ? WHERE codigo = ?");
            ps.setString(1, alimento.getNome());
            ps.setInt(2, alimento.getNutricao());
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Erro ao atualizar alimento");
    }

    public void removerAlimento(int codigo){
        try(Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM alimento WHERE codigo = ?");
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
