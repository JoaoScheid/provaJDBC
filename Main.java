import java.util.Scanner;

public class Main {
    private static CRUDPet crudPet = new CRUDPet();
    private static CRUDAlimento crudAlimento = new CRUDAlimento();
    private static CRUDBrincadeira crudBrincadeira = new CRUDBrincadeira();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


       // Pet pet = new Pet("Cachorro", true, true, 100, 100, 100, 100, 100, 100);
       // crudPet.adicionarPet(pet);

       // System.out.println(crudPet.buscarPetByCodigo(1));

        do{
            mostrarOpcoesMenu();
            int opcaoMenu = sc.nextInt();
            executarOpcao(opcaoMenu);
        }while (true);

    }

    public static void criarPet(){

        sc.nextLine();
        System.out.println("Digite o nome do pet:");
        String nome = sc.next();

        System.out.println("Digite a sede do pet:");
        int sede = sc.nextInt();

        System.out.println("Digite a fome do pet:");
        int fome = sc.nextInt();

        System.out.println("Digite a energia do pet:");
        int energia = sc.nextInt();

        System.out.println("Digite a diversao do pet:");
        int diversao = sc.nextInt();

        System.out.println("Digite a higiene do pet:");
        int higiene = sc.nextInt();

        System.out.println("Digite a vontade de ir no banheiro do pet:");
        int vontadeBanheiro = sc.nextInt();

        Pet pet = new Pet(nome,true, true, sede,fome, energia, diversao, higiene, vontadeBanheiro);
        crudPet.adicionarPet(pet);
    }

    public static void buscarTodosPets(){
        System.out.println(crudPet.buscarPets());
    }

    public static void buscarUmPet(){
        System.out.println("Qual o codigo do pet que voce deseja buscar?:");
        int codigo = sc.nextInt();

        System.out.println(crudPet.buscarPetByCodigo(codigo));
    }

    public static void atualizarPet(){
        sc.nextLine();
        System.out.println("ID do pet que quer atualizar:");
        int codigoPet = sc.nextInt();

        crudPet.buscarPetByCodigo(codigoPet);
        System.out.println("Novo nome");
        String novoNome = sc.next();

        System.out.println("Ainda esta acordado?:");
        boolean acordado= sc.nextBoolean();

        System.out.println("Ainda esta vivo?:");
        boolean vivo = sc.nextBoolean();

        System.out.println("Nova sede:");
        int novaSede = sc.nextInt();

        System.out.println("Nova fome:");
        int novaFome = sc.nextInt();

        System.out.println("Nova energia:");
        int novaEnergia = sc.nextInt();

        System.out.println("Nova diversao:");
        int novaDiversao = sc.nextInt();

        System.out.println("Nova higiene:");
        int novaHigiene = sc.nextInt();

        System.out.println("Nova vontade banheiro");
        int novaBanheiro = sc.nextInt();

        crudPet.updatePet(new Pet(novoNome, vivo, acordado, novaSede, novaFome, novaEnergia, novaDiversao, novaHigiene, novaBanheiro));


    }

    public static void deletarPet(){
        System.out.println("Qual o codigo do pet que você deseja deletar?:");
        int codigo = sc.nextInt();

        crudPet.removerPet(codigo);
    }

    public static void criarAlimento(){
        sc.nextLine();
        System.out.println("Digite o nome do alimento");
        String nome = sc.next();
        System.out.println("Digite a nutrição do alimento");
        int nutricao = sc.nextInt();

        Alimento alimento = new Alimento(nome, nutricao);

        crudAlimento.adicionarAlimento(alimento);
    }

    public static void buscarAlimentos(){
        System.out.println(crudAlimento.buscarAlimentos());
    }

    public static void buscarAlimento(){
        sc.nextLine();
        System.out.println("Qual o codigo do alimento que deseja buscar?:");
        int codigo = sc.nextInt();

        System.out.println(crudAlimento.buscarAlimentoByCodigo(codigo));
    }

    public static void deletarAlimento(){
        sc.nextLine();
        System.out.println("Qual o codigo do alimento que deseja remover?:");
        int codigo = sc.nextInt();

        crudAlimento.removerAlimento(codigo);
    }

    public static void criarBrincadeira(){

        sc.nextLine();
        System.out.println("Digite o nome da brincadeira:");
        String nome = sc.next();

        System.out.println("Digite a sede que a brincadeira causa:");
        int sede = sc.nextInt();

        System.out.println("Digite a fome que a brincadeira causa:");
        int fome = sc.nextInt();

        System.out.println("Digite a energia que o pet gasta na brincadeira:");
        int energia = sc.nextInt();

        System.out.println("Digite a diversao que a brincadeira causa:");
        int diversao = sc.nextInt();

        System.out.println("Digite a higiene que a brincadeira tira:");
        int higiene = sc.nextInt();



        Brincadeira brincadeira= new Brincadeira(nome, sede,fome, energia, diversao, higiene);
        crudBrincadeira.adicionarBrincadeira(brincadeira);
    }
    public static void mostrarOpcoesMenu(){
        System.out.println("==CRUD==" +
                "\n1-Criar pet" +
                "\n2-Buscar pets" +
                "\n3-Buscar pet" +
                "\n4-Atualizar pet" +
                "\n5-Deletar pet" +
                "\n6-Criar alimento" +
                "\n7-Buscar alimentos" +
                "\n8-Buscar alimento" +
                "\n9-Atualizar alimento" +
                "\n10-Deletar alimento");
    }

    public static void executarOpcao(int opcaoMenu){
        switch (opcaoMenu){
            case 1: {
                criarPet();
                break;
            }
            case 2: {
                buscarTodosPets();
                break;
            }
            case 3: {
                buscarUmPet();
                break;
            }

            case 4:{
                atualizarPet();
                break;
            }
            case 5: {
                deletarPet();
                break;
            }
            case 6: {
                criarAlimento();
                break;
            }
            case 7: {
                buscarAlimentos();
                break;
            }
            case 8:{
                buscarAlimento();
                break;
            }
            case 10:{
                deletarAlimento();
                break;
            }

        }
    }

}
