// proje ba?lang?c? Mert Kahraman 190101028
//Bu class tarih tutuyor
public class Date extends Object{
  //gun tutan field at?yorum.
  private int dateDay;
  //ay filed
  private int dateMonth;
  //yil field
  private int dateYear;
  
  
  //day month ve year?n class i�erisinde var olmas? i�in constructor yarat?yorum.
  public Date(int day, int month, int year){
    dateDay = day;
    dateMonth = month;
    dateYear = year;
  } 
  
  
  //methodlara ba?l?yorum
  //ilk method getDay, g�n� almam? sa?layacak ve bu g�n 1-31 aras?nda olmal?
  public int getDay(){
    if (dateDay >= 1 && dateDay <= 31){  
      return dateDay;
    }
    else return 0;
  }
  
  //methodum �al??t? ayn?s?n? ay i�in de yapaca??m, 1-12 aras?nda olmal?
  public int getMonth(){
    if (dateMonth >= 1 && dateMonth <= 12){  
      return dateMonth;
    }
    else 
      return 0;
  }
  
  //ay methodu da �al??t?, y?l methodunu yapmam gerekiyor ayn? ?ekilde fakat aral??? yok
  public int getYear(){
    return dateYear;
  }
  
  //setterlar? yazmaya ba?l?yorum
  // day i�in de?er vermemi sa?layan setter, e?er ge�ersiz de?er verilirse atama yap?lm?yor
  public void setDay(int dateDay){
    if(dateDay >= 1 && dateDay <= 31)
    this.dateDay = dateDay;
  }
  
  //month i�in setter
  public void setMonth(int dateMonth){
    if(dateMonth >= 1 && dateMonth <= 12)
    this.dateMonth = dateMonth;
  }
  
  //Year i�in setter
  public void setYear(int dateYear){
    this.dateYear = dateYear;
  }
  
  //g�ne bir ekler, g�n ve ay limiti asildigi zaman daha b�y�k zmaan limitini bir artt?racak bir method ayarl?yoruz
  //art?k y?llar? saym?yoruz
  public void incrementDay(){
  //icrementedDay ad?nda artm?? g�n� variable olarak ald?m
    int incrementedDay = this.getDay() + 1;
  //32 olursa e?er sonraki aya atlamas? laz?m
    if (incrementedDay == 32){
  //ay atlay?nca birinci g�ne d�nmesi laz?m
      this.setDay(1);
  //ayi bir atlatma
      if (getMonth() >= 1 && getMonth() < 12){
        this.setMonth(this.getMonth() + 1);
   }
  //ay 12 ise y?l? atlatma
      else if (getMonth() == 12){
        this.setMonth(1);
        this.setYear(this.getYear() + 1);
   }
  }
  //ayn? ay?n icerisindeyse g�n� belirten field bir artmal?
   else if(incrementedDay >= 1 && incrementedDay <= 31){
     this.setDay(incrementedDay);
  }
 }
  
  //eldeki tarihi string olarak yaz?p var olan toString methodunu override edece?im
  @Override
  public String toString(){
    return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
  }
  
  //equals methodunu override edece?im. Input bizim ayn? g�n ve ayl? datein objectiyse (y?l farkl?
  //olabilir true, di?er her t�rl� false.
  @Override
  public boolean equals(Object tarih){
    //ayn? classa m? sahipler kontrol�
    if (tarih instanceof Date){
      //tarihi kesin ?ekilde Date yapip tarihDate e atad?m
      Date tarihDate = (Date)tarih;
    // ayn? g�ne ve aya sahipler mi kontrol�
      if (this.getDay() == tarihDate.getDay() && this.getMonth() == tarihDate.getMonth()){
        return true;
    }
      else 
        return false;
    }
      else
        return false;
  }
}

  
  
