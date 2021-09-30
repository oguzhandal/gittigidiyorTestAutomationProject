# gittigidiyor-selenium-project

## Kullanmak için gereken ayarlar
1. LoginPage sayfasında sendKeys methodundaki istenen MAİL ve PASSWORLD alanlarını doldurunuz.
2. Test package nin altındaki Main clasına gidin.
3. Main classında login methodunun üzerinde bulunan @Test ve @Order(3) elementlerinin yorum satırını silin.
4. Projeyi artık çalıştırabilirsiniz edebilirsiniz.
---

Selenium Web Otomasyon
- www.gittigidiyor.com sitesi açılır.
- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur.
- Login işlemi kontrol edilir.
- Arama kutucuğuna bilgisayar kelimesi girilir.
- Arama sonuçları sayfasından 2.sayfa açılır.
- 2.sayfanın açıldığı kontrol edilir.
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
