
class Parameter {
        private String name;
        private String value;
     
        
        public Parameter(String name, String value) {
            this.name = name;
            this.value = value;
           
        }
        
        public String getName() {
            return name;
        }
        
        public String getValue() {
            return value;
        }
        
       public void print(){
           System.out.println("param name: "+ this.name);
           System.out.println("param value: "+ this.value);
       }
}
