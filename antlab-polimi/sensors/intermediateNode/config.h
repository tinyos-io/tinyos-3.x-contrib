/*
 * Author: Stefano Paniga
 * contact: stefano.paniga@mail.polimi.it
 */

#ifndef RADIOINTER_H
#define RADIOINTER_H

#define VIDEO_HEADER_LENGTH 3
#define PHOTO_HEADER_LENGTH 2
#define BIGMSG_DATA_SHIFT 6
#define PHOTO_DATA_LENGTH 40//(1<<BIGMSG_DATA_SHIFT)
#define VIDEO_DATA_LENGTH 40//64
//#define TOSH_DATA_LENGTH  (BIGMSG_HEADER_LENGTH+VIDEO_DATA_LENGTH)
#define DEST 0
#define SRC 10
#define MAX_RTX 5


typedef nx_struct radio_count_msg {
  nx_uint16_t counter;
} radio_count_msg_t;

enum {
  AM_RADIO_IMGSTAT_R = 127,
  AM_RADIO_PHOTO_R = 128,
  AM_RADIO_VIDEO_R = 129,
  AM_RADIO_TIME_TEST_R = 130,
  AM_RADIO_PKT_TEST_R = 131,
  AM_RADIO_CMD_S = 120,
  AM_RADIO_CMD_R = 120,
  AM_RADIO_IMGSTAT_S =  127,
  AM_RADIO_PHOTO_S = 128,
  AM_RADIO_VIDEO_S = 129,
  AM_RADIO_TIME_TEST_S =130,
  AM_RADIO_PKT_TEST_S = 131,
  AM_RADIO_QUEUE_TEST = 132,
  
};

typedef nx_struct video_radio_part{
	nx_uint8_t frame_id;	
	nx_uint16_t part_id;
	nx_uint8_t buf[VIDEO_DATA_LENGTH];
} video_radio_part_t;

typedef struct video_queue{
video_radio_part_t msg;
uint8_t sent;
} video_queue_t;

typedef nx_struct photo_radio_part{
	nx_uint16_t part_id;
	nx_uint8_t buf[PHOTO_DATA_LENGTH];
} photo_radio_part_t;


typedef nx_struct cmd_msg{
	nx_uint8_t cmd;
	nx_uint16_t val1;
	nx_uint16_t val2;
} cmd_msg_t;


typedef nx_struct pkt_test_msg{
nx_uint32_t rcv_inter_pkts;
nx_uint32_t rcv_bs_pkts;
nx_uint32_t rtx_camera_count;
nx_uint32_t rtx_inter_count;
nx_uint32_t frame_num;

} pkt_test_msg_t;

typedef nx_struct time_test_msg{
	nx_uint32_t acquire;
	nx_uint32_t process;
	nx_uint32_t sending;
	nx_uint32_t send_size;		
	nx_uint32_t id;	
	nx_uint32_t acq_period;
	nx_uint32_t pause_time;
} time_test_msg_t;

typedef nx_struct queue_test_msg{
	nx_uint16_t tx_pause;
	nx_uint16_t queue_size;
	nx_uint16_t queue_delta;
} queue_test_msg_t;

typedef nx_struct img_stat{
	nx_uint8_t type;
	nx_uint16_t width;
	nx_uint16_t height;
	nx_uint32_t data_size;
	nx_uint32_t timeAcq;
	nx_uint32_t timeProc;
	nx_uint32_t tmp1;
	nx_uint32_t tmp2;
	nx_uint32_t tmp3;
	nx_uint32_t tmp4;
} img_stat_t;



#endif
