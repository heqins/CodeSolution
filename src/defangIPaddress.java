public class defangIPaddress {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        defangIPaddress address = new defangIPaddress();
        System.out.println(address.defangIPaddr("192.168.18.1"));
    }
}
