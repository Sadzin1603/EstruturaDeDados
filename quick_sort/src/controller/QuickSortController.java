package controller;

public class QuickSortController{
    public QuickSortController(){
        super();
    }
    public void ordenar(int[] vetor){
        quick(vetor,0,vetor.length-1);
    }
    private void quick(int[] vetor,int inicio,int fim){
        if(fim>inicio){
            int indexPivo = dividir(vetor,inicio,fim);
            quick(vetor,inicio,indexPivo-1);
            quick(vetor,indexPivo+1,fim);
        }
    }
    private int dividir(int[] vetor, int inicio,int fim){
        int pivo = vetor[inicio];
        int pontoDir = fim;
        int pontoEsq = inicio+1;

        while(pontoEsq <= pontoDir){
            while(pontoEsq <=pontoDir && vetor[pontoEsq] <= pivo){
                pontoEsq++;
            }
            while(pontoDir >= pontoEsq && vetor[pontoDir] > pivo){
                pontoDir--;
            }
            if(pontoEsq < pontoDir){
                trocar(vetor,pontoDir--,pontoEsq++);
            }
        }
        trocar(vetor,inicio,pontoDir);
        return pontoDir;
    }
    private void trocar(int[] vetor,int i,int j){
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}