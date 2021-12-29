package com.Aldeamo.test.service;


import com.Aldeamo.test.persistence.model.Arrays;
import com.Aldeamo.test.persistence.repository.ArrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BartenderService {

    private int q;
    private String array;

    @Autowired
    ArrayRepository arrayRepository;

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] arrayPrimeNumbers(){
        int[] primeNum = new int[this.q];
        int i = 0;
        int j = 0;
        int k = 2;
        while(i<3){
            while(j==0){
                if(isPrime(k)){
                    primeNum[i] = k;
                    i++;
                    j=1;
                    k++;
                }else{
                    k++;
                }
            }
            j=0;
        }
        return primeNum;
    }

    private int[] convertString(){
        String[] strArray = this.array.split(",");
        int[] myArray = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++) {
            myArray[i] = Integer.parseInt(strArray[i]);
        }
        return myArray;
    }

    private String algorithm(){
        int[] array = convertString();
        int[] primeArray = arrayPrimeNumbers();
        int[] arrayA = new int[array.length];
        int k = 0;
        for (int j = 0; j<primeArray.length;j++) {
            for (int i = array.length - 1; i >= 0; i--) {
                if(array[i]% primeArray[j]== 0 && array[i]>0) {
                    arrayA[k] = array[i];
                    array[i] = -1;
                    k++;
                }
                if(j==primeArray.length-1 && i == 0){
                    for (int l = array.length - 1; l >= 0; l--) {
                        if (array[l] > 0){
                            arrayA[k] = array[l];
                            k++;
                        }
                    }

                }
            }
        }
        String result = "Respuesta: ";
        for(int i = 0 ;  i < arrayA.length; i++){
            if (i < arrayA.length-1){
                result += Integer.toString(arrayA[i])+",";
            }else{
                result += Integer.toString(arrayA[i]);
            }

        }
        return result;
    }

    public  String Request(int q, Integer id){
        Arrays array = arrayRepository.findById(id).orElse(new Arrays(0,""));
        if(array.getArrayString().equals("")){
            return "El número proporcionado como id no es valido se debe enviar un número de 1 a 5";
        }else{
            this.array = array.getArrayString();
            this.q = q;
            return algorithm();
        }
    }


}
