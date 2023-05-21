import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MyList<T>{
  private T[] array;
  private int count = 10;

  public MyList(){
      array = (T[]) new Object[count];
  }
  public MyList(int a){
      this.count = a;
      array = (T[]) new Object[count];
  }

  public int size(){
      int inds = 0;
      for (T value : array){
          if (value != null){
              inds++;
          }
      }
      return inds;
  }
  public int getCount(){
      return array.length;
  }
  public void increCapasity(){
      T[] array2 = (T[]) new Object[getCount() * 2];
      for (int i = 0;i<this.size();i++){
              array2[i] = array[i];
      }
      array = array2;
  }

  public void add(T data){
      if ((this.size() - this.getCount()) == 0){
          this.increCapasity();
          array[this.size()] = data;
      }
      else {
          array[this.size()] = data;
      }
  }

  public T get(int indeks){
      if (indeks > this.getCount()){
          System.out.println("Girilen indeks değeri liste boyutundan büyük");
          return null;
      }else {
          return array[indeks];
      }
  }

  public String remove(int indeks){
      if (indeks > (this.array.length-1)){
          System.out.println("Böyle bir değer bulunamadı");
          return null;
      }else{
          int ind = indeks +1;
          for (int i = ind;ind < array.length;ind++){
              array[ind-1] = array[ind];
          }
          String data = (indeks +1) + ". Eleman başarı ile silindi";
          return data;
      }

  }
  public String set(int indeks,T data){
      if (indeks > (array.length -1)){
          System.out.println("Girilen indeks değeri liste boyutundan büyük");
          return null;
      }else {
          array[indeks] = data;
          String mesaj = "değiştirildi";
          return mesaj;
      }
  }

  public String toPrint(){
    String str = "[";
    for (T value : this.array){
        if (value != null){
           str = str.concat(value+",");
        }
    }
    str = str.substring(0,str.length()-1);
    str = str.concat("]");
    return str;
  }

  public int indexOf(T data){
      int value = -1;
      for (int i = 0;i < this.size();i++){
          if (array[i] == data){
              value = i;
              break;
          }
      }

      return value;
  }

  public int lastIndexOf(T data){
      int value = -1;
      for (int i = 0;i < this.size();i++){
          if (array[i] == data){
              value = i;
          }
      }

      return value;
  }

  public boolean isEmpty(){
     return size() < 1;
  }

  public T[] toArray(){
      return this.array;
  }

  public void clear(){
      for (int i = 0; i< this.size();i++){
          array[i] = null;
      }
  }

  public MyList<T> subList(int star,int finish){
      MyList<T> list = new MyList<>();
      for (int i = star;i<= finish;i++){
          list.add(array[i]);
      }
      return list;
  }

  public boolean contains(T data){
      boolean value = false;
      for (int i = 0;i<this.size();i++){
          if (array[i] == data){
              value = true;
          }
      }
      return value;
  }


}

