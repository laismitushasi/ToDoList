package todolist;

import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tarefas = new String[10];
        boolean[] concluidas = new boolean[10];

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("=== LISTA DE TAREFAS V1===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Sair");

            System.out.println("\nEscolha um opcao");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    int posicaoLivre = -1;

                    for (int i = 0; i < tarefas.length; i++) {
                        if (tarefas[i] == null) {
                            posicaoLivre = i;
                            break;
                        }
                    }

                    if (posicaoLivre == -1) {
                        System.out.println("A lista de tarefas esta cheia");
                    } else {
                        System.out.println("digite a tarefa: ");
                        tarefas[posicaoLivre] = scanner.nextLine();
                        concluidas[posicaoLivre] = false;
                        System.out.println("tarefa adicionada");
                    }

                    break;
                    
                case 2:
                    System.out.println("========Minhas Tarefas======");
                    
                    boolean existeTarefa = false;
                    
                    for(int i = 0; i < tarefas.length; i++){
                        if(tarefas[i] != null){
                            existeTarefa = true;
                            
                            if (concluidas[i] == true) {
                                
                                System.out.println((i + 1) + " - [x] " + tarefas[i]);
                            } else {
                                System.out.println((i + 1) + " - [ ] " + tarefas[i]);
                            }
                        }
                    }
                    
                    if (existeTarefa == false){
                        System.out.println("nao tem tarefa");
                    }
                    
                    break;
                    
                case 3:
                    System.out.println("digite o numero da tarefa que voce concluiu: ");
                    int numeroConcluir = scanner.nextInt();
                    
                    int indiceConcluir = numeroConcluir - 1;
                    
                    if (indiceConcluir >= 0 && indiceConcluir < tarefas.length && tarefas[indiceConcluir] != null){
                        concluidas[indiceConcluir] = true;
                        
                        System.out.println("tarefa marcada como concluida");
                    }else{
                        System.out.println("tarefa invalida");
                    }
                    
                    break;
                    
                case 4:
                    System.out.println("Digite o numero da tarefa que deseja excluir: ");
                    int numeroExcluir = scanner.nextInt();
                    
                    int indiceExcluir = numeroExcluir - 1;
                    
                    if (indiceExcluir >= 0 && indiceExcluir < tarefas.length && tarefas[indiceExcluir] != null){
                        
                        tarefas[indiceExcluir] = null;
                        concluidas[indiceExcluir] = false;
                        
                        System.out.println("tarefa excluida com sucesso");
                    }else{
                        System.out.println("tarefa invalida");
                    }
                    
                    break;
                    
                case 5:
                    System.out.println("Programa encerrado");
                break;
                default:
                    System.out.println("opcao invalida");
                break;
            }
        }
    }
}

