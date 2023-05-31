package gesia.gesiabackend.modules.nfv;

import gesia.gesiabackend.modules.nft.Nft;

import java.util.List;

public interface CertificationRepositoryCustom {

    List<Nfv> findNFVListByCertId(Long id);

    List<Nft> findNftListByAccountSq(Long id);
}
