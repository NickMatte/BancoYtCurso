public class ContaBanco {
    //atributos
    public int numConta;
    protected String tipo; //cc para conta corrente e cp para conta poupança
    private String dono;
    private double saldo;
    private boolean status; //aberta = true, fechado = falso

    // se abrir uma conta cc, recebe 50 reais
    //se abrir uma cp, ganha 150 reais
    //para fechar uma conta, não pode ter saldo positivo nem negativo, precisa ser verificado
    //para depositar, o status tem que ser verdadeiro
    //para sacar, precisa ter status verdadeiro e precisa ter saldo e não pode sacar mais do que o sado
    //pagar mensalidade, cada vez que for chamado, o cliente que tiver um CC paga 12 reais, o cliente que tiver cp, paga 20 reais

    //Metodos especiais
    public ContaBanco(){
        this.saldo = 0;
        this.status = false;
        //System.out.println("Nova conta criada. Numero da conta: " + this.numConta );
        System.out.println("Agora você precisa abrir a conta, e definir o dono e o tipo de conta. CC para corrente e CP para poupança");
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void estadoAtual() {
        System.out.println("-----------------------");
        System.out.println("Conta: "+ this.getNumConta());
        System.out.println("Tipo: "+ this.getTipo());
        System.out.println("Dono: "+ this.getDono());
        System.out.println("Saldo: "+ this.getSaldo());
        System.out.println("Status: "+ this.getStatus());
    }

    //metodos personalizados
    public void abrirConta(String t){
        this.setStatus(true);
        this.setTipo(t);
        if(t == "CC") {
            this.setSaldo(50);
            System.out.println("Conta corrente aberta, adicionado 50 reais no saldo.");
        }else if (t == "CP"){
                this.setSaldo(150);
                System.out.println("Conta poupança aberta, adicionado 150 reais no saldo.");
        }
    }

    public void fecharConta() {
        if(this.getSaldo() > 0) {
            System.out.println("Sua conta possui saldo, saque tudo e tente novamente");
        }else if(this.getSaldo() < 0) {
            System.out.println("Sua conta possui saldo devedor e não pode ser fechada");
        }else {
            this.setStatus(false);
            System.out.println("Sua conta foi fechada.");
        }
    }

    public void depositar(float v){
        if(this.getStatus() == true){
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Valor depositado na conta de " + this.getDono() + " \nSaldo: : " + this.getSaldo());

        }else{
            System.out.println("A conta não está aberta, então não pode depositar.");
        }
    }

    public void sacar(float v) {
        if (this.getStatus() == true) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado na conta de: " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque");
            }
        } else {
            System.out.println("Impossivel sacar de uma conta fechado.");
        }
    }

    public void pagarMensal() {
        int v = 0;
        if(this.getTipo() == "CC"){
            v = 12;
        } else if(this.getTipo() == "CP"){
            v = 20;
        }
        if(this.getStatus()){
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono());
        }else {
            System.out.println(" impossivel pagar uma conta fechada!");
        }
    }
}
