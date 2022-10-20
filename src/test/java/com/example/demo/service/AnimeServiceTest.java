package com.example.demo.service;

import com.example.demo.entity.Anime;
import com.example.demo.mapper.AnimeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AnimeServiceTest {

  @InjectMocks
  AnimeService animeService;

  @Mock
  AnimeMapper animeMapper;

  @Test
  public void アニメが全件取得できること() {
    doReturn(List.of(new Anime(1, "abc", "def"), new Anime(2, "ghi", "jkl"))).when(animeMapper).findAll();
    List<Anime> actual = animeService.getAllAnime();
    assertThat(actual).isEqualTo(List.of(new Anime(1, "abc", "def"), new Anime(2, "ghi", "jkl")));
  }

}
