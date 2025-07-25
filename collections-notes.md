# Java 102 Notları

## Set Interface

### HashSet Sınıfı

- Liste tipinde veri tutmayı sağlar.
- Veri kümesinde tekrarlayan değer tutmaz.
- Tekrar eden değer tutmamayı nesnelerdeki hashCode fonksiyonunu kullanarak sağlar. 
- "null" değer tutabilir. null bellekte yeri ayrılmış ancak bir ddeğeri olmayan referanstır.
- Sıralama garantisi yoktur. Eleman sırası hash kodlarıona göre belirlenir. Bu nedenle çıktı sırası tahmin edilmez.
- Sadece belirli türde veri tutabilir. Farklı türde veri eklenmeye çalışılırsa derleme hatası alınır.
- HashSet'e başlangıç boyutu verilebilir ancak zorunlu değildir. Dinamik bir yapıya sahiptir ihtiyaca göre kendini genişletir.

### LinkedHashSet Sınıfı
- Liste tutan sıralı bir HashSet türüdür. Sıralama sırası korunur.
- Eklendikleri sıra ile yineleme yapılır.

### TreeSet Sınıfı
- Veri kümesine konulan elemanların verilen kurala göre sıralanmasını sağlar.
- Bunu yapabilmek için kullanılan sınıfın sıralanabilir olması gerekir.
- Bir sınıfın sıralanabilir olması için “Comparable” interface’den kalıtım alıp “compareTo” metodunu doldurması gerekmektedir.
- Nesne üzerindeki “compareTo” fonksiyonu küçükten büyüğe doğal sıralama imkanı sağlar.

## List Interface
- Veriler, geliş sırasına göre (ordered) tutulur.
- List'lerin her elemanı bellekte kendine özgü bir alan tutar. List üzerinde veri ekleme ve bu verilere erişme indis(index) denilen integer sayılar üzerinden yapılır. Başlangıç indisi sıfırdır.
- List Interface'inden kalıtım alan sınıflarda, tekrarlı (duplicate) veya null değerli elemanlar tutulabilir.
- Dizilerin kullanıldığı her yerde List'ler kullanılabilirler ayrıca birbirlerine dönüştürülebilirler. Veri işlemeye yarayan metotlarından dolayı List'ler, programcılar, bu yapıları daha çok tercih ederler.
- Bu interface'te implemente edilen metotlar;
  - get(int index) : Verilen indisteki nesneyi getirir.
  - add(Object element) : Listeye eleman eklemeyi sağlar. Eğer, indise birlikte nesne verilirse, ilgili indisin gösterdiği noktaya elemanı ekler. Aynı indiste başka bir nesne varsa onun üzerine yazar.
  - indexOf(Object) : Verilen bir nesnenin listede hangi indiste tutulduğunu bulur.
  - remove(int index) : Verilen indisteki elemanı siler.
  - set(int index, Object element) : Verilen indisteki elemanı başka bir eleman ile değiştirir.
  - subList(int fromIndex, int toIndex) : Verilen indisler arasındaki elemanlardan oluşan yeni bir liste oluşturur.
-  Vector ve Stack sınıfları, legacy (miras) sınıflardır. Java 5'ten önceki versiyonlarında var olup, artık daha iyi alternatifleri olan sınıflardır. Hala bu sınıfları kullanan projeler olabileceği için tamamen kaldırılamazlar.

### ArrayList
- ArrayList, liste halindeki verileri dinamik diziler(array) kullanarak saklar. Default boyutu 10’dur.
- Bu dizilere yeni eleman eklendikçe eğer boyutu yetmiyorsa, çalışma zamanında, arka tarafta var olan dizinin boyutunun 2 katı olan yeni dizi tanımlanır. Eski dizideki elemanlar indis değerleri korunarak yeni diziye aktarılırlar. Esnek fakat maliyetli bir collection’dır.
- Veri saklamak ve veriye erişimin yoğun olduğu durumlar için ArrayList tercih edilir.
- ArrayList’ler tanımlanırken <>(diamond) operatörleri arasına içerisinde tutulacak değerlerin tipi yazılmalıdır.
- Araya ekleme veya silme işlemleri yapılması durumunda kaydırma işlemleri yapılması gerekir. Bu durum performansı düşürür.
- ArrayList sınıfı thread-safe değildir. Bir ArrayList’e aynı anda birden fazla thread erişebilir. Bu durum veri bütünlüğünü bozar.

### LinkedList
- Her eleman önceki ve sonraki elemanını işaret edecek şekilde iki yönlü bir ilişki kurulmuştur.
- Listenin ben başına hem sonuna eleman eklenip çıkarılabilir, bu işlemler için metotlar mevcuttur.
- LinkedList’te eleman silme veya araya eleman ekleme durumlarında kaydırma işlemi yapılmaz.
- Bu listeye gönderilen veriler, arka planda özel bir obje ile sarılır (wrap) edilir. Bu objeler birbirini gösterecek şekilde referanslar objelere konur, böylece birbirlerine bağlanırlar.
- Kullanılacak veri grubunu bir listeye koymamız ve bu gruba veri ekleme işlemi sürekli yapılacaksa, LinkedList kullanılması önerilir.
- LinkedList sınıfı, ArrayList gibi thread-safe değildir. Bu List türünde de veri bütünlüğünü sorunu vardır.
- LinkedList, hem List interface'inden hem Queue (Kuyruk) interface'inden miras alan bir sınıftır.

## Queue Interface

###  Queue LinkedList
- Queue arayüzü Java Collections Framework ‘un bir üyesidir. İşlemlerden geçmeden önce öğeleri depolanmasını sağlar. Collection arayüzünün bir altarayüzü olduğundan, onun bütün metotlarını kullanır. Onlara ek olarak, kuyruk yapısındaki ekleme, silme gibi işlemleri kolaylaştıran metotlara sahiptir.
- Ortaya çıkış nedeniyle, Queue bir FIFO (first-in-first-out, ilk giren ilk çıkar) yapısıdır. Ancak, Queue ve Collection arayüzündeki metotlar kullanılarak, FIFO yapısı LIFO (last-input-first-output, son giren ilk çıkar) yapısı gibi kullanılabilir.
-  Fıfo ve LIFO yapılarına öncelik sıralamalı kuyruklar (priority queues) denilir. Bu yapılarda, öğeler ya doğal sıralarında ya da bu iş için oluşturulan comparator tarafından sıraya konulur.
- LinkedList yapısı her ikisinden daha geneldir. Yapı ister FIFO, ister LIFO olsun, ilk çıkan öğe kuyruğun başındadır; remove() ya da poll() metodu ile alınır. 
  - element() : Kuyruğun başındaki öğeyi verir, ama onu kuyruktan atmaz.
  - add(eleman): Parametrede verilen elemanı kuyruğa ekler. İşlemin başarısız olması durumunda hata fırlatır. 
  - offer(eleman): Parametrede verilen elemanı kuyruğa ekler. İşlemin başarısız olması durumunda null döner. 
  - poll(): Kuyruğun başındaki elemanı kuyruktan çıkartır. 
  - peek(): Kuyrukta sıradaki elemana ulaşmak için kullanılır.

### Priority Queue
- Bir koleksiyon içinde öncelik sırasını farklı amaçlarla belirleyebiliriz.
- Biraz genellemeyle, PriorityQueue yapısına da kuyruk diyeceğiz; ama burada yüklenen anlamı FIFO yapısından farklı olabilir. Sıralama bazen öğelerin doğal sırasıdır, bazen ilgili Comparator tarafından belirlenen sıradır.
- Bir PriorityQueue kuyruğunda öğeler ya doğal sıralarındadır ya da kuruluş anında kullanılan Comparator’un yaptığı sıradadırlar. Tabii, böyle oluşu, hangi constructor'ın kullanıldığına bağlıdır
- PriorityQueue kuyruğuna null öğe konamaz. 
- Doğal sırasında olan bir PriorityQueue kuyruğuna, kendi öğeleriyle bağdaşmayan (mukayese edilemeyen) bir nesne konulamaz. Böyle yapılırsa derleyiciden ClassCastException hatası alınır.
- PriorityQueue kuyruğunun başı (head), kullanılan sıralamaya göre en küçük olan öğedir. Eğer en küçük olan birden çok öğe varsa, kuyruğun başı onlardan birisidir. Poll(), remove(), peek() ve element() metotları kuyruğun başına erişir.



