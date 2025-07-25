# Java 102 Notları

## Map Interface
Map Interface somut sınıflarındandır. HashMap sınıfına, karışık eşleme de denilebilir. Eşleme tablosuna eleman ekleme, çıkartma işlemlerinde ve anahtarı verilen elemanı tabloda bulma işlemlerinde oldukça etkilidir.
Map Interface’i kullanan sınıflar aşağıdaki metodlara sahiptir;
- clear: Map içinde bulunan bütün değerleri siler.
- containsKey (Object key): Belli bir anahtar daha önceden girilmiş mi sorgular.
- containsValue (Object value):Belli bir obje daha önceden girilmiş mi sorgular.
- get (Object key): Anahtara karşılık gelen objeyi döndürür.
- put (Object key, Object value): Anahtar — değer ikilisini kayıt eder.
- remove (Object key):Belli bir anahtara karşılık gelen değeri siler.
- size: O zaman kadar kayıt edilmiş anahtar — değer ikili sayısını verir.

### LinkedHashMap
LinkedHashMap, Map arayüzünü uygulayan bir sınıftır. Hashtable gibi anahtar-değer (key-value) yapısıyla çalışır; ayrıca, LinkedList gibi elemanların eklenme sırasını korur.


Sıralama önemli değil → HashMap

Ekleme sırasına göre gezmek istiyorsan → LinkedHashMap

Anahtarlar sıralı olsun istiyorsan → TreeMap

Thread-safe ama eski bir yapı gerekiyorsa → Hashtable (ama artık önerilmez)

