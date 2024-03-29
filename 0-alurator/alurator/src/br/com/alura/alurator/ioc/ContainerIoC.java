package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class ContainerIoC {

	private Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();
	
	public Object getInstancia(Class<?> tipoFonte) {

		Class<?> tipoDestino = mapaDeTipos.get(tipoFonte);
		
		if(tipoDestino != null) {
			return getInstancia(tipoDestino);
		}
		
		Stream<Constructor<?>> construtores = Stream.of(tipoFonte.getDeclaredConstructors());

		Optional<Constructor<?>> construtorPadrao = construtores
				.filter(construtor -> construtor.getParameterCount() == 0).findFirst();

		try {

			if (construtorPadrao.isPresent()) {

				Object instancia = construtorPadrao.get().newInstance();
				return instancia;
			} else {
				Constructor<?> constructor = tipoFonte.getDeclaredConstructors()[0];

				List<Object> params = new ArrayList<>();

				for (Parameter param : constructor.getParameters()) {
					Class<?> tipoParametro = param.getType();
					params.add(getInstancia(tipoParametro));

				}

				return constructor.newInstance(params.toArray());

			}

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException();
		}

	}

	public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
		mapaDeTipos.put(tipoFonte, tipoDestino);
	}

	private boolean verificaCompatibilidade(Class<?> tipoFonte, Class<?> tipoDestino) {
		return tipoFonte.isAssignableFrom(tipoDestino);
	}

	//verifica��o na ra�a
//	private boolean verificaCompatibilidade(Class<?> tipoFonte, Class<?> tipoDestino) {
//		boolean compativel;
//
//		if (tipoFonte.isInterface()) {
//			compativel = Stream.of(tipoDestino.getInterfaces())
//					.anyMatch(interfaceImplementada -> interfaceImplementada.equals(tipoFonte));
//		} else {
//			compativel = tipoDestino.getSuperclass().equals(tipoFonte) || tipoDestino.equals(tipoFonte);
//		}
//
//		return compativel;
//	}

}
