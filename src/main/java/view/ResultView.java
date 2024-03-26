package view;

import domain.Lotto;
import domain.LottoResult;
import domain.Prize;

public class ResultView {

  public void print(String result) {
    System.out.println(result);
  }

  public void print(Lotto lotto){
    System.out.println(lotto.getNumbers());
  }

  public void printLottoResult(LottoResult result){
    StringBuilder sb = new StringBuilder();
    sb.append("당첨 통계\n--------\n");
    for(var entry : result.getMatchedResult().entrySet()){
      sb.append(String.format("%d개 일치 (%d원)- %d개\n", entry.getKey(), Prize.findPrizeMoneyByCount(entry.getKey()), entry.getValue()));
    }
    sb.append(String.format("\n총 수익률은 %.2f입니다.%s", result.getProfitRate(), result.getProfitRate() >= 1 ? " -> 이익입니다." : " -> 손해입니다."));
    System.out.println(sb.toString());
  }

}
