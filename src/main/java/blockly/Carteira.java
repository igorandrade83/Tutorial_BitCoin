package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Carteira {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// CriarCarteira
	public static Var CriarCarteira() throws Exception {
		return new Callable<Var>() {

			private Var novaCarteira = Var.VAR_NULL;

			public Var call() throws Exception {
				novaCarteira = Var
						.valueOf(cronapi.blockchain.bitcoin.BitcoinOperations.createWallet(
								Var.valueOf(cronapi.io.Operations.fileAppDir().toString()
										+ Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNome"))
										.getTypedObject(java.lang.String.class),
								Var.valueOf("test").getTypedObject(java.lang.String.class)));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.inputEnd"), novaCarteira);
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var DescriptografarCarteira() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.blockchain.bitcoin.BitcoinOperations
						.decryptWallet(
								Var.valueOf(cronapi.io.Operations.fileAppDir().toString()
										+ Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNome"))
										.getTypedObject(java.lang.String.class),
								Var.valueOf("test").getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputSenha"))
										.getTypedObject(java.lang.String.class));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var EnviarFundos() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.blockchain.bitcoin.BitcoinOperations
						.sendCoins(
								Var.valueOf(cronapi.io.Operations.fileAppDir().toString()
										+ Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNome"))
										.getTypedObject(java.lang.String.class),
								Var.valueOf("test").getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputVal"))
										.getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputCred"))
										.getTypedObject(java.lang.String.class));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var ObterInformacoes() throws Exception {
		return new Callable<Var>() {

			private Var saldoCarteira = Var.VAR_NULL;
			private Var EnderecoCarteira = Var.VAR_NULL;

			public Var call() throws Exception {
				saldoCarteira = Var
						.valueOf(cronapi.blockchain.bitcoin.BitcoinOperations.getReceiveAddress(
								Var.valueOf(cronapi.io.Operations.fileAppDir().toString()
										+ Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNome"))
										.getTypedObject(java.lang.String.class),
								Var.valueOf("test").getTypedObject(java.lang.String.class)));
				EnderecoCarteira = Var
						.valueOf(cronapi.blockchain.bitcoin.BitcoinOperations.getReceiveAddress(
								Var.valueOf(cronapi.io.Operations.fileAppDir().toString()
										+ Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNome"))
										.getTypedObject(java.lang.String.class),
								Var.valueOf("test").getTypedObject(java.lang.String.class)));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.inputchave"), EnderecoCarteira);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.inputSaldoSatoshi"), cronapi.conversion.Operations.toString(saldoCarteira));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.inputSaldoBTC"),
						cronapi.math.Operations.divisor(
								cronapi.conversion.Operations
										.toDouble(cronapi.conversion.Operations.toString(saldoCarteira)),
								Var.valueOf(100000000)));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var criptografarCarteira() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.blockchain.bitcoin.BitcoinOperations
						.encryptWallet(
								Var.valueOf(cronapi.io.Operations.fileAppDir().toString()
										+ Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNome"))
										.getTypedObject(java.lang.String.class),
								Var.valueOf("test").getTypedObject(java.lang.String.class),
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputSenha"))
										.getTypedObject(java.lang.String.class));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
