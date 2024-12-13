import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDPet {

    BancoDeDados bancoDeDados = new BancoDeDados();



    public Pet adicionarPet(Pet pet){
        try(Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO pet(nome, vivo, acordado, sede, fome, energia, diversao, higiene, vontadeBanheiro) VALUES (?,?,?,?,?,?,?,?,?)"
            , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pet.getNome());
            ps.setBoolean(2, pet.isVivo());
            ps.setBoolean(3, pet.isAcordado());
            ps.setInt(4, pet.getSede());
            ps.setInt(5, pet.getFome());
            ps.setInt(6, pet.getEnergia());
            ps.setInt(7, pet.getDiversao());
            ps.setInt(8, pet.getHigiene());
            ps.setInt(9, pet.getVontadeBanheiro());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                pet.setCodigo(rs.getInt(1));
                return pet;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException("Não foi possivel adicionar um pet");
    }

    public List<Pet> buscarPets(){
        try (Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM pet");
            ResultSet rs = ps.executeQuery();
            List<Pet> pets = new ArrayList<>();
            while (rs.next()) {
                pets.add(new Pet(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getBoolean(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)
                ));
            }
            return pets;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Pet buscarPetByCodigo(int codigo)  {
        try (Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM pet WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                boolean vivo = rs.getBoolean("vivo");
                boolean acordado = rs.getBoolean("acordado");
                int sede = rs.getInt("sede");
                int fome = rs.getInt("fome");
                int energia = rs.getInt("energia");
                int diversao = rs.getInt("diversao");
                int higiene = rs.getInt("higiene");
                int vontadeBanheiro = rs.getInt("vontadeBanheiro");
                return new Pet(codigo, nome, vivo, acordado, sede, fome, energia, diversao, higiene, vontadeBanheiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Pet nao encotrado");
    }

    public void updatePet(Pet pet){
        buscarPetByCodigo(pet.getCodigo());
        try (Connection connection = bancoDeDados.getConexao()){
            PreparedStatement ps = connection.prepareStatement("UPDATE pet SET nome = ?, vivo = ?, acordado = ?, sede = ?, fome = ?, energia = ?, diversao = ?, higiene = ?, vontadeBanheiro = ? WHERE codigo = ?");
            ps.setString(1, pet.getNome());
            ps.setBoolean(2, pet.isVivo());
            ps.setBoolean(3, pet.isAcordado());
            ps.setInt(4, pet.getSede());
            ps.setInt(5, pet.getFome());
            ps.setInt(6, pet.getEnergia());
            ps.setInt(7, pet.getDiversao());
            ps.setInt(8, pet.getHigiene());
            ps.setInt(9, pet.getVontadeBanheiro());
            ps.setInt(10, pet.getCodigo());
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Erro ao atualizar pet");
    }
    public void removerPet(int codigo){
        try(Connection connection = bancoDeDados.getConexao()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM pet WHERE codigo = ?");
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
