package domain.lotto.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinNumbers {

    Set<LottoNumber> primaryNumbers;
    LottoNumber bounusNumber;

    public WinNumbers(Set<LottoNumber> primaryNumbers, LottoNumber bounusNumber){
        validateNumberLength(primaryNumbers.size());
        this.primaryNumbers = primaryNumbers;
        this.bounusNumber = bounusNumber;
    }

    public WinNumbers(List<LottoNumber> primaryNumbers, LottoNumber bounusNumber){
        validateNumberLength(primaryNumbers.size());
        this.primaryNumbers = new HashSet<>(primaryNumbers);
        this.bounusNumber = bounusNumber;
    }

    public WinNumbers(List<Integer> primaryNumbers, int bounusNumber){
        validateNumberLength(primaryNumbers.size());
        this.primaryNumbers = primaryNumbers.stream().map(LottoNumber::of).collect(
            Collectors.toSet());
        this.bounusNumber = LottoNumber.of(bounusNumber);
    }

    public int getMatchCount(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .reduce(0, (acc, number) -> acc + ( isInLotto(number) ? 1 : 0));
    }

    private boolean isInLotto(Integer number) {
        return primaryNumbers.contains(LottoNumber.of(number)) || number.equals( bounusNumber.getNumber());
    }

    private void validateNumberLength(Integer numberLength){
        if(numberLength != 6){
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }
}
