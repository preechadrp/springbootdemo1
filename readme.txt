== spring boot demo เบื้องต้น ===
- relax binding  (การ map ชื่อระหว่าง java กับ config/environment varible/database table field)

  camel case = companyTaxId    เริ่มด้วยตัวพิมพ์เล็กและแบ่งคำด้วยตัวใหญ่  (ใช้ตั้งชื่อตัวแปร)
  kebab case = company-tax-id  ขีดกลาง     (map กับ application.properties/yml)
  snake case = company_tax_id  ใช้ขีดล่าง     (map ชื่อตัวแปรไปยังชื่อฟิลด์ใน table ของ database)
  pascal case = CompanyTaxId   เริ่มด้วยตัวพิมพ์ใหญ่และแบ่งคำด้วยตัวใหญ่  (ใช้ตั้งชื่อ class)
  upper snake case = COMPANY_TAX_ID
  
- การเริ่มสร้าง project ด้วย springboot
  1. https://start.spring.io/
  2. eclipse plugins (ติดตั้ง springboot tool) 
     spring tools  (https://spring.io/tools#eclipse เป็นของ vmware ที่เอา eclipse+springboot plugins พร้อมใช้งาน)
     
- lombok plugins for eclipse

- api
  controller
  service
  logback
  global exception handler
  component

- การอ่านค่าจาก config/application.properties
  
  แบบใช้ @Value("${property.name}")  // property.name = value
  private String propertyName;  
  
  แบบใช้ @ConfigurationProperties(prefix = "property")  // property.name = value
  
  ลำดับการอ่านค่า config
    -D > Environment Varible > application.properties/.yml > (./config > ./ > src/main/resources)
    ตัวอย่าง
    1. .properties เช่น abc.companyTaxId=mycomp 
    2. Environment Varible เช่น ABC_COMPANY_TAX_ID=mycomp
    3. -D เช่น java -Dabc.companyTaxId=mycomp -jar myapp.jar
    
- การเชื่อม database ด้วย spring data jpa  (spring jdbc, spring data jdbc)
  entity  (@ToString, @Accessors(chain = true))
  repository
  dto
  dao
  jsonNode/Jackson
  @Bean/CommandLineRunner

- schedule
  แบบ fixedRate
  แบบ fixedDelay
  แบบ cron

- spring security  //TODO
  jwt  (jason web token)
  nimbus library  (รองรับการทำงาน jwt,jws)

  