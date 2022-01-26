package datas;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;

public class MainDatas {
  public static void main(String[] args) {
    LocalDate hoje = LocalDate.now();
    System.out.println(hoje);

    LocalDate olimpiadasParis = LocalDate.of(2024, Month.JULY, 26);
    LocalDate olimpiadasParisInt = LocalDate.of(2024, 7, 26);
    System.out.println(olimpiadasParis);
    System.out.println(olimpiadasParisInt);

    int anos = olimpiadasParis.getYear() - hoje.getYear();
    System.out.println(anos);
    System.out.println(hoje.getEra());
    System.out.println(hoje.getDayOfWeek());
    System.out.println(hoje.getDayOfYear());
    System.out.println(olimpiadasParis.getDayOfYear());

    Period periodo = Period.between(hoje, olimpiadasParis);
    System.out.println(periodo);
    System.out.println("Quanto tempo falta para as olimpíadas de Paris:");
    System.out.format("%d ano(s), %d mês(es) e %d dia(s).%n", periodo.getYears(), periodo.getMonths(), periodo.getDays());
    System.out.println((periodo.getYears()*12)+periodo.getMonths() + " meses.");
    System.out.println(ChronoUnit.MONTHS.between(hoje, olimpiadasParis) + " meses.");
    System.out.println(ChronoUnit.DAYS.between(hoje, olimpiadasParis) + " dias.");

    long diasAteOlimpiadas = hoje.until(olimpiadasParis, ChronoUnit.DAYS);
    long mesesAteOlimpiadas = hoje.until(olimpiadasParis, ChronoUnit.MONTHS);
    System.out.println(diasAteOlimpiadas + " dias.");
    System.out.println(mesesAteOlimpiadas + " meses.");


    System.out.println("O produto ficará bloqueado de hoje até: ");
    System.out.println(hoje.plusDays(1));
    System.out.println(hoje.plusMonths(6));
    System.out.println(hoje.plusYears(2));
    System.out.println(hoje.minusDays(25));
    System.out.println(hoje.minusMonths(2));
    System.out.println(hoje.minusYears(2));
    System.out.println(hoje);

    LocalDate proximasOlimpiadas = olimpiadasParis.plusYears(4);
    System.out.println(proximasOlimpiadas);

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String dataFormatada = proximasOlimpiadas.format(formato);
    System.out.println(dataFormatada);

    TemporalAdjuster ajustadorProximaSexta = TemporalAdjusters.next(DayOfWeek.FRIDAY);
    LocalDate proximaSexta = hoje.with(ajustadorProximaSexta);
    String proximaSextaFormatada = proximaSexta.format(formato);
    System.out.println("A data da próxima sexta-feira é: " + proximaSextaFormatada);

    LocalDate aniversario = LocalDate.of(2022, Month.FEBRUARY, 25);
    TemporalAdjuster ajustadorProxSabado = TemporalAdjusters.next(DayOfWeek.SATURDAY);
    LocalDate festaDeAniversario = aniversario.with(ajustadorProxSabado);
    String dataFestaAniversarioFormatada = festaDeAniversario.format(formato);
    System.out.println("A minha festa de aniversário acontecerá em: " + dataFestaAniversarioFormatada);

    TemporalAdjuster ajustadorProximaOuMesmaSexta = TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY);
    LocalDate festaNaSexta = aniversario.with(ajustadorProximaOuMesmaSexta);
    String festaNaSextaFormatada = festaNaSexta.format(formato);
    System.out.println("Todos convidados para minha festa de aniversário no dia: " + festaNaSextaFormatada);

    LocalDateTime agora = LocalDateTime.now();
    System.out.println(agora);

    DateTimeFormatter formatoComTempo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSS");
    String dataHoraFormatado = agora.format(formatoComTempo);
    System.out.println(dataHoraFormatado);

    YearMonth copaDoMundo2022 = YearMonth.of(2022, Month.NOVEMBER);
    System.out.println(copaDoMundo2022);

    MonthDay natal = MonthDay.of(Month.DECEMBER, 25);
    System.out.println(natal);

    LocalDate natalDesseAno = natal.atYear(Year.now().getValue());
    long diasAteONatal = LocalDate.now().until(natalDesseAno, ChronoUnit.DAYS);
    System.out.println("Dias até o Natal: " + diasAteONatal);

    LocalTime intervalo = LocalTime.of(12, 30);
    System.out.println(intervalo);

    Instant instante = Instant.now();
    System.out.println(instante);

    Instant inicio = Instant.now();

    int j = 0;
    for (int i = 0; i < 1000000; i++) {
      j++;
    }

    System.out.println(j);

    Instant fim = Instant.now();

    Duration duracao = Duration.between(inicio, fim);
    long duracaoEmMilissegundos = duracao.toMillis();
    System.out.println(duracaoEmMilissegundos);

    LocalDateTime olimpiadasComHoras = LocalDateTime.of(2024, Month.JULY, 26, 8, 10);

    Duration duracaoEntreHojeEOlimpiadas = Duration.between(agora, olimpiadasComHoras); //não aceita LocalDate
    long duracaoEmDias = duracaoEntreHojeEOlimpiadas.toDays();
    System.out.println(duracaoEmDias);

    // Period periodoComHoras = Period.between(agora, olimpiadasComHoras); //Erro

    ZoneId fusoHorarioSP = ZoneId.of("America/Sao_Paulo");
    ZonedDateTime agoraComFusoHorario = ZonedDateTime.now(fusoHorarioSP);
    System.out.println(agoraComFusoHorario);

    ZoneId fusoHorarioNY = ZoneId.of("America/New_York");

    LocalDateTime saidaVooSemFuso = LocalDateTime.of(2022, Month.APRIL, 4, 22, 30);
    LocalDateTime chegadaVooSemFuso = LocalDateTime.of(2022, Month.APRIL, 5, 7, 10);

    System.out.println(saidaVooSemFuso);
    System.out.println(chegadaVooSemFuso);

    ZonedDateTime saidaVooComFuso = ZonedDateTime.of(saidaVooSemFuso, fusoHorarioSP);
    ZonedDateTime chegadaVooComFuso = ZonedDateTime.of(chegadaVooSemFuso, fusoHorarioNY);

    System.out.println(saidaVooComFuso);
    System.out.println(chegadaVooComFuso);

    Duration duracaoVooSemFuso = Duration.between(saidaVooSemFuso, chegadaVooSemFuso);
    System.out.println(duracaoVooSemFuso);
    Duration duracaoVooComFuso = Duration.between(saidaVooComFuso, chegadaVooComFuso);
    System.out.println(duracaoVooComFuso);

    LocalDateTime fimHorarioVerao2013SemFuso = LocalDateTime.of(2014, Month.FEBRUARY, 15, 23, 0);
    ZonedDateTime fimHorarioVerao2013ComFuso = fimHorarioVerao2013SemFuso.atZone(fusoHorarioSP);

    System.out.println(fimHorarioVerao2013ComFuso);

    ZonedDateTime maisUmaHora = fimHorarioVerao2013ComFuso.plusHours(1);
    System.out.println(maisUmaHora);
    System.out.println(maisUmaHora.plusHours(1));

    OffsetDateTime offsetAgora = OffsetDateTime.now();
    System.out.println(offsetAgora);
    ZoneOffset zoneOffset = ZoneOffset.of("+02:00");
    OffsetDateTime novoOffsetAgora = OffsetDateTime.now(zoneOffset);
    System.out.println(novoOffsetAgora);

    Instant now = Instant.now();
    Clock clock = Clock.fixed(now, fusoHorarioNY);
    OffsetDateTime offsetDateTime = OffsetDateTime.now(clock);
    ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
    System.out.println(offsetDateTime);
    System.out.println(zonedDateTime);

    OffsetDateTime offsetDateTimePlusSixMonths = offsetDateTime.plusMonths(6);
    ZonedDateTime zonedDateTimePlusSixMonths = zonedDateTime.plusMonths(6);

    System.out.println(offsetDateTimePlusSixMonths);
    System.out.println(zonedDateTimePlusSixMonths);
    System.out.println(offsetDateTimePlusSixMonths.toEpochSecond() - zonedDateTimePlusSixMonths.toEpochSecond());

    System.out.println(offsetDateTimePlusSixMonths.toLocalDateTime());
    System.out.println(zonedDateTimePlusSixMonths.toLocalDateTime());
  }


}

