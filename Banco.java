import java.util.List;

public class Banco {

    private static CRUDPet petCrud = new CRUDPet();
    private static CRUDAlimento alimentoCrud = new CRUDAlimento();
    private static CRUDBrincadeira brincadeiraCrud = new CRUDBrincadeira();

    public Pet salvarPet(Pet pet){
        petCrud.adicionarPet(pet);
        return pet;
    }

    public Brincadeira salvarBrincadeira(Brincadeira brincadeira){
        brincadeiraCrud.adicionarBrincadeira(brincadeira);
        return brincadeira;
    }

    public Alimento salvarAlimento(Alimento alimento){
        alimentoCrud.adicionarAlimento(alimento);
        return alimento;
    }

    public void removerPet(Pet pet){
        petCrud.removerPet(pet.getCodigo());
    }

    public void removerAlimento(Alimento alimento){
        alimentoCrud.removerAlimento(alimento.getCodigo());
    }

    public void removerBrincadeira(Brincadeira brincadeira){
        brincadeiraCrud.removerBrincadeira(brincadeira.getCodigo());
    }

    public Alimento procurarAlimento(Alimento alimento){
        petCrud.buscarPetByCodigo(alimento.getCodigo());
        return alimento;
    }

    public Brincadeira procurarBrincadeira(Brincadeira brincadeira){
        brincadeiraCrud.buscarBrincadeiraByCodigo(brincadeira.getCodigo());
        return brincadeira;
    }

    public Pet procurarPet(Pet pet){
        petCrud.buscarPetByCodigo(pet.getCodigo());
        return pet;
    }

    public List<Alimento> procurarAlimentos(){
        alimentoCrud.buscarAlimentos();
        return null;
    }

    public List<Brincadeira> procurarBrincadeiras(){
        brincadeiraCrud.buscarBrincadeira();
        return null;
    }

    public List<Pet> procurarPets(){
        petCrud.buscarPets();
        return null;
    }


}
